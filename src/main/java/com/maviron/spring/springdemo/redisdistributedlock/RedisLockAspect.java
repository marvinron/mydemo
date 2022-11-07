package com.maviron.spring.springdemo.redisdistributedlock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RedisLockAspect.java
 * @Description Redis分布式锁
 * @createTime 2022年10月18日 10:39:00
 */
@Component
@Aspect
@Slf4j
public class RedisLockAspect {
    private static final ScheduledExecutorService SCHEDULED =
            new ScheduledThreadPoolExecutor(1,
                    new BasicThreadFactory.Builder().namingPattern("redisLock-schedule-pool").daemon(true).build());
    private static ConcurrentLinkedQueue<RedisLockDefinitionHolder> holderList = new ConcurrentLinkedQueue<>();
    @Autowired
    private RedisTemplate redisTemplate;

    {
        SCHEDULED.scheduleAtFixedRate(() -> {
            try {
                Iterator<RedisLockDefinitionHolder> iterator = holderList.iterator();
                while (iterator.hasNext()) {
                    RedisLockDefinitionHolder holder = iterator.next();
                    //判空
                    if (holder == null) {
                        iterator.remove();
                        continue;
                    }
                    //判断key是否有效  无效的话进行移除
                    if (redisTemplate.opsForValue().get(holder.getBusinessKey()) == null) {
                        iterator.remove();
                        continue;
                    }
                    //超时重试次数 超过 给线程设定中断
                    if (holder.getCurrentCount() > holder.getTryCount()) {
                        holder.getCurrentThread().interrupt();
                        iterator.remove();
                        continue;
                    }
                    //判断是否进入三分之一的时间
                    long curTime = System.currentTimeMillis();
                    boolean shouldExtend = (holder.getLastModifyTime() + holder.getModifyPeriod()) <= curTime;
                    if (shouldExtend) {
                        holder.setLastModifyTime(curTime);
                        redisTemplate.expire(holder.getBusinessKey(), holder.getLockTime(), TimeUnit.SECONDS);
                        holder.setCurrentCount(holder.getCurrentCount() + 1);
                    }

                }
            } catch (Exception e) {

            }
        }, 0, 2, TimeUnit.MILLISECONDS);

    }

    /**
     * 获取指定类上的指定方法
     *
     * @param clazz          指定类
     * @param name           指定方法
     * @param parameterTypes 参数类型列表
     * @return 找到就返回method，否则返回null
     */
    public static Method getDeclaredMethodFor(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethodFor(superClass, name, parameterTypes);
            }
        }
        return null;
    }

    /**
     * @annotation 中的路径表示拦截特定注解
     */
    @Pointcut("@annotation(com.maviron.spring.springdemo.redisdistributedlock.RedisLockAnnotation)")
    public void redisLockPC() {

    }

    /**
     * redis的AOP
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "redisLockPC()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 解析参数
        Method method = resolveMethod(pjp);
        //获取该方法的redis分布式锁的注解信息
        RedisLockAnnotation annotation = method.getAnnotation(RedisLockAnnotation.class);
        RedisLockTypeEnum typeEnum = annotation.typeEnum();
        Object[] params = pjp.getArgs();
        String businessKey = params[annotation.lockField()].toString();
        String uniqueValue = UUID.randomUUID().toString();
        //加锁
        Object result = null;
        try {
            boolean isSuccess = redisTemplate.opsForValue().setIfAbsent(businessKey, uniqueValue, Duration.ofMinutes(1L));
            if (!isSuccess) {
                throw new Exception("You can't do it，because another has get the lock =-=");
            }
            redisTemplate.expire(businessKey, annotation.lockTime(), TimeUnit.SECONDS);
            Thread currentThread = Thread.currentThread();
            holderList.add(new RedisLockDefinitionHolder(businessKey, annotation.lockTime(), System.currentTimeMillis(), currentThread, annotation.tryCount()));
            result = pjp.proceed();
            //线程被中断 抛出异常 中断此次请求
            if (currentThread.isInterrupted()) {
                throw new Exception("You had been interrupted =-=");
            }
        } catch (Exception e) {
            log.error("has some error, please check again", e);
        } finally {
            // 请求结束后，强制删掉 key，释放锁
            releaseValidKey(businessKey, Thread.currentThread());
        }
        return result;
    }

    /**
     * 根据pjp的信息获取方法
     *
     * @param pjp
     * @return
     */
    private Method resolveMethod(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Class<?> targetClass = pjp.getTarget().getClass();

        Method method = getDeclaredMethodFor(
                targetClass,
                signature.getName(),
                signature.getMethod().getParameterTypes());
        if (method == null) {
            throw new IllegalStateException("Cannot resolve target method: " + signature.getMethod().getName());
        }
        return method;
    }
    private void releaseValidKey(String businessKey, Thread currentThread){
        RedisLockDefinitionHolder redisLockDefinitionHolder = holderList.stream()
                .filter(h->businessKey.equals(h.getBusinessKey()))
                .findFirst().orElse(null);
        if(redisLockDefinitionHolder != null && redisLockDefinitionHolder.getCurrentThread().equals(currentThread)){
            //请求结束后
            redisTemplate.delete(businessKey);
        }
    }
}
