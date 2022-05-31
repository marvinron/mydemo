package com.maviron.spring.springdemo.async;

import cn.hutool.core.util.StrUtil;
import org.springframework.lang.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThreadFactoryBuilder.java
 * @Description 线程工厂
 * @createTime 2022年05月11日 16:10:00
 */
public class ThreadFactoryBuilder {
    /**
     * 线程创建线程的工厂类
     */
    private ThreadFactory threadFactory;

    /**
     * 线程名的前缀
     */
    @Nullable
    private String namePrefix;
    /**
     * 未捕获的异常处理器
     */
    @Nullable
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    /**
     * 线程的优先级,0-10之间,值越大优先级越高
     * 优先级高表示在争抢CPU时有更高概率抢占到CPU资源,不是表示优先级高的线程一定会在优先级低的线程之前执行
     */
    private int priority = 5;
    @Nullable
    private ThreadDecorator threadDecorator;

    /**
     * 创建线程工厂
     *
     * @return
     */
    public static ThreadFactoryBuilder create() {
        return new ThreadFactoryBuilder();
    }

    /**
     * 设置用于创建基础线程的线程工厂
     *
     * @param threadFactory 用于创建基础线程的线程工厂
     * @return this
     */
    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        return this;
    }

    /**
     * 设置线程装饰器
     *
     * @param threadDecorator 线程装饰器
     * @return thisl
     */
    public ThreadFactoryBuilder setThreadDecorator(ThreadDecorator threadDecorator) {
        this.threadDecorator = threadDecorator;
        return this;
    }

    /**
     * 设置线程名前缀，例如设置前缀为share-thread，则线程名为hutool-thread-1之类。
     *
     * @param namePrefix 线程名前缀
     * @return this
     */
    public ThreadFactoryBuilder setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
        return this;
    }

    /**
     * 设置线程优先级
     *
     * @param priority 优先级
     * @return this
     * @see Thread#MIN_PRIORITY
     * @see Thread#NORM_PRIORITY
     * @see Thread#MAX_PRIORITY
     */
    public ThreadFactoryBuilder setPriority(int priority) {
        if (priority < Thread.MIN_PRIORITY) {
            throw new IllegalArgumentException(StrUtil.format("Thread priority ({}) must be >= {}", priority, Thread.MIN_PRIORITY));
        }
        if (priority > Thread.MAX_PRIORITY) {
            throw new IllegalArgumentException(StrUtil.format("Thread priority ({}) must be <= {}", priority, Thread.MAX_PRIORITY));
        }
        this.priority = priority;
        return this;
    }
    /**
     * 设置未捕获异常的处理方式
     *
     * @param uncaughtExceptionHandler {@link Thread.UncaughtExceptionHandler}
     * @return this
     */
    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        return this;
    }
    /**
     * 构建{@link ThreadFactory}
     *
     * @return {@link ThreadFactory}
     */
    public ThreadFactory build() {
        return build(this);
    }

    private static ThreadFactory build(ThreadFactoryBuilder builder){
        final ThreadFactory threadFactory = (null != builder.threadFactory)
                ? builder.threadFactory
                : Executors.defaultThreadFactory();
        final String namePrefix = builder.namePrefix;
        final Thread.UncaughtExceptionHandler handler = builder.uncaughtExceptionHandler;
        final AtomicLong count = (null == namePrefix) ? null : new AtomicLong();
        return r -> {
            if (builder.threadDecorator != null) {
                r = builder.threadDecorator.decorate(r);
            }
            final Thread thread = threadFactory.newThread(r);
            if (null != namePrefix) {
                thread.setName(namePrefix + count.getAndIncrement());
            }
            thread.setPriority(builder.priority);
            if (null != handler) {
                thread.setUncaughtExceptionHandler(handler);
            }
            return thread;
        };
    }
}
