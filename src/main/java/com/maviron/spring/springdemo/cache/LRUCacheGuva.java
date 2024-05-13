package com.maviron.spring.springdemo.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName LRUCacheGuva.java
 * @Description google的Guva的缓存  https://blog.csdn.net/hello__ZC/article/details/131426454
 * @createTime 2024年03月11日 11:49:00
 */
@Slf4j
public class LRUCacheGuva {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    LoadingCache<Long, String> cache
            // CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
            = CacheBuilder.newBuilder()
            // 设置并发级别为3，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(3)
            // 过期
            .refreshAfterWrite(5, TimeUnit.SECONDS)
            // 初始容量
            .initialCapacity(1000)
            // 最大容量，超过LRU
            .maximumSize(2000).build(new CacheLoader<Long, String>() {

                @Override
                @Nonnull
                public String load(@Nonnull Long key) throws Exception {
                    Thread.sleep(1000);
                    return (Instant.now()+"");
                }

                @Override
                @Nonnull
                public ListenableFuture<String> reload(@Nonnull Long key, @Nonnull String oldValue) throws Exception {
                    ListenableFutureTask<String> futureTask = ListenableFutureTask.create(() -> {
                        Thread.sleep(1000);
                        return (Instant.now()+"");
                    });
                    executorService.submit(futureTask);
                    return futureTask;
                }
            });

    com.google.common.cache.LoadingCache<String, String> googleCache = CacheBuilder.newBuilder()
            //最大容量为100（基于容量进行回收）
            .maximumSize(100)
            //配置写入后多久使缓存过期-下文会讲述
            .expireAfterWrite(20, TimeUnit.SECONDS)
            //配置写入后多久刷新缓存-下文会讲述
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    log.info("加载数据");
                    Thread.sleep(5000);
                    return s + System.currentTimeMillis();
                }
            });
//
//            .build(CacheLoader.asyncReloading(new CacheLoader<String, String>() {
//                @Override
//                public String load(String s) throws Exception {
//                    log.info("异步加载数据");
//                    Thread.sleep(5000);
//                    return s + System.currentTimeMillis();
//                }
//            }, executorService));
}
