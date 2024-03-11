package com.maviron.spring.springdemo.cache;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

/**
 * <dependency>
 *   <groupId>com.googlecode.concurrentlinkedhashmap</groupId>
 *   <artifactId>concurrentlinkedhashmap-lru</artifactId>
 *   <version>1.4.2</version>
 * </dependency>
 * googlecode的LRU实现 线程安全 可以完全用于生产
 */
public class LRUCacheExample {

    public static void main(String[] args) {
        // 创建一个LRU cache实例
        ConcurrentLinkedHashMap<String, String> lruCache = new ConcurrentLinkedHashMap.Builder<String, String>()
                .maximumWeightedCapacity(3) // 设置最大容量为3
                .build();

        // 向LRU cache中添加条目
        lruCache.put("key1", "value1");
        lruCache.put("key2", "value2");
        lruCache.put("key3", "value3");

        // 获取条目
        String value1 = lruCache.get("key1");
        System.out.println("Value for key1: " + value1); // Output: Value for key1: value1

        // 添加新条目，导致LRU cache中的最旧条目被移除
        lruCache.put("key4", "value4");

        // 尝试获取已被移除的条目
        String value2 = lruCache.get("key2");
        System.out.println("Value for key2 after eviction: " + value2); // Output: Value for key2 after eviction: null
    }
}
