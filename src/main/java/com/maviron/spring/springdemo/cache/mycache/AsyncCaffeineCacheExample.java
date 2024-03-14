package com.maviron.spring.springdemo.cache.mycache;

import cn.hutool.core.date.StopWatch;
import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.*;

public class AsyncCaffeineCacheExample {

    private static Executor executor = Executors.newFixedThreadPool(10); // 创建一个线程池用于异步加载数据
    private static AsyncCache<String, String> cache = Caffeine.newBuilder()
            .maximumSize(1000) // 设置缓存最大容量
            .expireAfterWrite(10, TimeUnit.MINUTES) // 设置缓存条目写入后的过期时间
            .buildAsync();

    public static CompletableFuture<String> getValueFromCache(String key) {
        return cache.get(key, k-> {
            // 异步加载数据的逻辑，这里简单返回一个值
            return "Value for key " + k;
        });
    }

    public static void main(String[] args) {
        // 模拟高并发访问
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            new Thread(() -> {
                String key = "key" + index;
                getValueFromCache(key).thenAccept(value -> {
                    System.out.println("Thread " + Thread.currentThread().getId() + " - Key: " + key + ", Value: " + value);
                });
            }).start();
        }
        stopWatch.stop();
        System.out.println("===="+stopWatch.getTotalTimeMillis());
    }
}
