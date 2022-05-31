package com.maviron.spring.springdemo.async.config;

import cn.hutool.core.io.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AsyncThreadPoolProperties.java
 * @Description AsyncThreadPoolProperties
 * @createTime 2022年05月11日 16:30:00
 */
@Configuration
public class AsyncThreadPoolProperties {
    /**
     * 核心线程数量
     */
    private int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;

    /**
     * 最大线程数量
     */
    private int maximumPoolSize = corePoolSize + 10;
    /**
     * 非核心线程数的留存时间
     */
    private long keepAliveTime = 2 * 60;
    /**
     * 队列大小,大量任务堆积在队列内等待执行没有多大意义,该值过大会有OOM风险
     */
    private int queueSize = 200;
    /**
     * 拒绝执行策略,默认的拒绝策略是将该任务返回至原线程调用(大量任务堆积会导致原线程(服务)受到影响)
     */
    private Class<? extends RejectedExecutionHandler> rejectedExecutionHandlerType = ThreadPoolExecutor.DiscardPolicy.class;
    /**
     * 线程名称前缀,创建的线程名称为 前缀+数值(从0开始自增)
     */
    private String threadNamePrefix = "custom-thread-pool:thread-";
    /**
     * 线程的优先级,0-10之间,值越大优先级越高,默认是5
     * 优先级高表示在争抢CPU时有更高概率抢占到CPU资源,不是表示优先级高的线程一定会在优先级低的线程之前执行
     */
    private int priority = 5;
    /**
     * 线程池关闭时是否需要等待执行中的任务完成
     */
    private boolean awaitTermination = true;
    /**
     * 线程池关闭时等待执行中的任务完成的最大等待时间(秒为单位)
     */
    private long awaitTerminationSeconds = 10;
    public boolean isAwaitTermination() {
        return awaitTermination;
    }

    public void setAwaitTermination(boolean awaitTermination) {
        this.awaitTermination = awaitTermination;
    }

    public long getAwaitTerminationSeconds() {
        return awaitTerminationSeconds;
    }

    public void setAwaitTerminationSeconds(long awaitTerminationSeconds) {
        this.awaitTerminationSeconds = awaitTerminationSeconds;
    }
    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public Class<? extends RejectedExecutionHandler> getRejectedExecutionHandlerType() {
        return rejectedExecutionHandlerType;
    }

    public void setRejectedExecutionHandlerType(Class<? extends RejectedExecutionHandler> rejectedExecutionHandlerType) {
        this.rejectedExecutionHandlerType = rejectedExecutionHandlerType;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "AsyncThreadPoolProperties{" +
                "corePoolSize=" + corePoolSize +
                ", maximumPoolSize=" + maximumPoolSize +
                ", keepAliveTime=" + keepAliveTime +
                ", queueSize=" + queueSize +
                ", rejectedExecutionHandlerType=" + rejectedExecutionHandlerType +
                ", threadNamePrefix='" + threadNamePrefix + '\'' +
                ", priority=" + priority +
                ", awaitTermination=" + awaitTermination +
                ", awaitTerminationSeconds=" + awaitTerminationSeconds +
                '}';
    }

    public static void main(String[] args) {
        String fileName = "123.txt";
        String suffix = FileUtil.extName(fileName);
        System.out.println(suffix);
    }
}
