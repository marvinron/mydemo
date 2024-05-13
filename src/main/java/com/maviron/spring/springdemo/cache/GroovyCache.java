package com.maviron.spring.springdemo.cache;

import org.apache.groovy.util.concurrent.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import org.apache.groovy.util.concurrent.concurrentlinkedhashmap.Weighers;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName GroovyCache.java
 * @Description TODO
 * @createTime 2024年04月26日 11:05:00
 */
public class GroovyCache {
    public static ConcurrentLinkedHashMap<String, String> cache = new ConcurrentLinkedHashMap.Builder<String, String>()
            .maximumWeightedCapacity(2).weigher(Weighers.singleton()).build();

    public static void main(String[] args) {

    }
}
