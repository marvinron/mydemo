package com.maviron.spring.springdemo.cache.mycache;

import cn.hutool.core.date.StopWatch;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class CaffeineCacheExample {

    private static Cache<String, String> cache = Caffeine.newBuilder()
            .maximumSize(3) // 设置缓存最大容量
            .expireAfterWrite(10, TimeUnit.MINUTES) // 设置缓存条目写入后的过期时间
            .build();

    public static String getValueFromCache(String key) {
        return cache.get(key, k -> {
            // 如果缓存中没有该键值对，则加载数据并放入缓存
            return "Value for key " + k;
        });
    }

    public static void main(String[] args) {
        // 模拟高并发访问
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            String key = "key" + index;
            String value = getValueFromCache(key);
            System.out.println("Thread " + Thread.currentThread().getId() + " - Key: " + key + ", Value: " + value);

        }
        stopWatch.stop();
        System.out.println("=========="+stopWatch.getTotalTimeMillis());

        String key997 = getValueFromCache("key2");
        String key998 = getValueFromCache("key5");
        String key990 = getValueFromCache("key8");
        ConcurrentMap<String, String> stringStringConcurrentMap = cache.asMap();
        System.out.println(stringStringConcurrentMap);
    }
}
