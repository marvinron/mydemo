package com.maviron.spring.springdemo.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 能够保证线程安全的LRU缓存
 *
 * @param <K>
 * @param <V>
 */
public class ConcurrentLRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedHashMap<K, Long> accessOrder;

    public ConcurrentLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>(capacity);
        this.accessOrder = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public void put(K key, V value) {
        synchronized (cache) {
            if (cache.size() >= capacity) {
                evictLeastRecentlyUsed();
            }
            cache.put(key, value);
            accessOrder.put(key, System.nanoTime());
        }
    }

    public V get(K key) {
        synchronized (cache) {
            if (cache.containsKey(key)) {
                accessOrder.put(key, System.nanoTime());
                return cache.get(key);
            }
            return null;
        }
    }

    private void evictLeastRecentlyUsed() {
        K keyToRemove = accessOrder.entrySet().iterator().next().getKey();
        cache.remove(keyToRemove);
        accessOrder.remove(keyToRemove);
    }

    public static void main(String[] args) {
        ConcurrentLRUCache<Integer, String> cache = new ConcurrentLRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two

        cache.put(4, "Four");

        System.out.println(cache.get(3)); // Output: null, as it was the least recently used
    }
}
