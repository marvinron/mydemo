package com.maviron.spring.springdemo.apiretry.aspect;

import cn.hutool.core.thread.ThreadUtil;
import com.maviron.spring.springdemo.apiretry.Retry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RetryAspect.java
 * @Description 重试切面
 * @createTime 2022年05月11日 15:28:00
 */
@Component
@Aspect
@ConditionalOnProperty(prefix = "retry", name = "enabled", havingValue = "true")
public class RetryAspect {

    Logger logger = LoggerFactory.getLogger(RetryAspect.class);

    @Pointcut("@annotation(com.maviron.spring.springdemo.apiretry.Retry)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doRetry(ProceedingJoinPoint pjp) throws Throwable {
        //获取注解
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        try {
            return pjp.proceed();
        } catch (Exception e) {
            Retry retry = AnnotationUtils.findAnnotation(method, Retry.class);
            if (retry != null) {
                String title = retry.title();
                int times = retry.retryTimes();
                long interval = retry.excuteInterval();
                Class<? extends Throwable>[] retryForExceptions = retry.retryFor();
                Class<? extends Throwable>[] notRetryExceptions = retry.notRetry();
                if (times < 1) {
                    throw e;
                }
                int currentRetryTimes = 0;
                while (true) {
                    logger.info("{} 接口失败重试中,第 {} 次重试...", title, currentRetryTimes++);
                    try {
                        if (interval > 0) {
                            ThreadUtil.safeSleep(interval);
                        }
                        return pjp.proceed();
                    } catch (Throwable ex) {
                        if (currentRetryTimes > times) {
                            throw ex;
                        }
                    }
                }
            }

        }
        throw new RuntimeException("异常了");
    }

}
