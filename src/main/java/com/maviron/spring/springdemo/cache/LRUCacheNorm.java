package com.maviron.spring.springdemo.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 简单的LRU缓存
 *
 * @param <K>
 * @param <V>
 */
public class LRUCacheNorm<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

    public LRUCacheNorm(int capacity) {
        // cacheMap = new LinkedHashMap<K,V>(capacity, 0.75f, true);
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
    public V put (K key, V value, Long expireTime) {
        V put = super.put(key, value);
        removeAfterExpireTime(key, expireTime);
        return put;
    }

    private void removeAfterExpireTime(K key, long expireTime) {
        scheduledExecutorService.schedule(() -> {
            //过期后清除该键值对
            super.remove(key);
        }, expireTime, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        LRUCacheNorm<Integer, String> cache = new LRUCacheNorm<>(3);
        cache.put(1, "One",1000L);
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println(cache);
        System.out.println(cache.get(1));
        System.out.println(cache);// Output: One
        System.out.println(cache.get(2));// Output: Two
        System.out.println(cache);
        cache.put(4, "Four");
        System.out.println(cache);

        System.out.println(cache.toString());
        System.out.println(cache.get(3)); // Output: null, as it was the least recently used
    }
}
