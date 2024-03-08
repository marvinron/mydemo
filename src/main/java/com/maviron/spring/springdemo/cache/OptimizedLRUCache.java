package com.maviron.spring.springdemo.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 应对高并发以及线程安全的缓存
 * @param <K>
 * @param <V>
 */
public class OptimizedLRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public OptimizedLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(K key, V value) {
        lock.writeLock().lock();
        try {
            cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public V get(K key) {
        lock.readLock().lock();
        try {
            return cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        OptimizedLRUCache<Integer, String> cache = new OptimizedLRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println(cache.get(1)); // Output: One
        System.out.println(cache.get(2)); // Output: Two

        cache.put(4, "Four");

        System.out.println(cache.get(3)); // Output: null, as it was the least recently used
    }
}
