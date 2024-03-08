package com.maviron.spring.springdemo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 简单的LRU缓存
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println(cache);
        System.out.println(cache.get(1));
        System.out.println(cache);// Output: One
        System.out.println(cache.get(2));// Output: Two
        System.out.println(cache);
        cache.put(4, "Four");
        System.out.println(cache);

        System.out.println(cache.get(3)); // Output: null, as it was the least recently used
    }
}
