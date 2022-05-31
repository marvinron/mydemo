package com.maviron.spring.springdemo.apiretry;

import java.lang.annotation.*;

/**
 * 重试注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Retry {
    /**
     * 重试日志标题
     *
     * @return
     */
    String title() default "";

    /**
     * 重试日志次数
     *
     * @return
     */
    int retryTimes() default 1;

    /**
     * 重试日志间隔
     *
     * @return
     */
    long excuteInterval() default 0;

    /**
     * 指定异常进行重试
     *
     * @return
     */
    Class<? extends Throwable>[] retryFor() default {Exception.class};

    /**
     * 排除指定异常进行重试
     *
     * @return
     */
    Class<? extends Throwable>[] notRetry() default {};

}
