package com.maviron.spring.springdemo.test;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class CacheExample2 {
    private ConcurrentHashMap<String, LongAdder> cache = new ConcurrentHashMap<>();

    public void addToCache(String key, long value) {
        cache.computeIfAbsent(key, k -> new LongAdder()).add(value);
    }

    public long getFromCache(String key) {
        return cache.getOrDefault(key, new LongAdder()).longValue();
    }

    @Test
    public void testCacheExample() throws Exception{
        Thread thread = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                addToCache("20230809_123213_123123", 1);
            }
        });
        thread.start();

        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                addToCache("20230809_123213_123123", 1);
            }
        });
        thread2.start();

        Thread thread3 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                addToCache("20230809_123213_123123", 1);
            }
        });
        thread3.start();
        Thread.sleep(1000);

        long fromCache = getFromCache("20230809_123213_123123");
        System.out.println(fromCache);
    }
}