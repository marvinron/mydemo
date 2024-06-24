package com.maviron.spring.springdemo.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThreadPoolExecutorConfig.java
 * @Description TODO
 * @createTime 2024年06月19日 15:44:00
 */
@Configuration
public class ThreadPoolExecutorConfig {
    @Bean
    public Executor bidThreadPoolExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(2000);
        //最大线程数
        executor.setMaxPoolSize(2000);
        //队列容量
        executor.setQueueCapacity(Integer.MAX_VALUE);
        //线程名字前缀
        executor.setThreadNamePrefix("-*-*-*-adx_bid-*-*-*-");
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.initialize();
        return executor;
    }
}
