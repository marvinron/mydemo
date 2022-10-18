package com.maviron.spring.springdemo.redisdistributedlock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redis分布式注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RedisLockAnnotation {
    /**
     * 特定参数识别  默认取第0个下标
     *
     * @return
     */
    int lockField() default 0;

    /**
     * 默认重试次数
     *
     * @return
     */
    int tryCount() default 3;

    /**
     * 自定义加锁类型
     *
     * @return
     */
    RedisLockTypeEnum typeEnum();

    /**
     * 释放时间 秒
     *
     * @return
     */
    long lockTime() default 30;

}
