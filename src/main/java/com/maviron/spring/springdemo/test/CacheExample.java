package com.maviron.spring.springdemo.test;

import java.util.concurrent.ConcurrentHashMap;

public class CacheExample {
    private ConcurrentHashMap<String, Long> cache = new ConcurrentHashMap<>();

    public void addToCache(String key, long value) {
        cache.compute(key, (k, v) -> (v == null) ? value : v + value);
    }

    public long getFromCache(String key) {
        return cache.getOrDefault(key, 0L);
    }
}