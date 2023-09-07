package com.maviron.spring.springdemo.demo.cukoofilter;

import redis.clients.jedis.Jedis;

public class CountMinSketchWithBitmap {
    private Jedis jedis;
    private int numHashes;
    private int width;

    public CountMinSketchWithBitmap(int numHashes, int width) {
        jedis = new Jedis("152.136.136.185", 8111);
        jedis.auth("Gameley668");
        jedis.select(6);
        this.numHashes = numHashes;
        this.width = width;
    }

    public void increment(String element) {
        for (int i = 0; i < numHashes; i++) {
            long hash = hash(element, i);
            //jedis.hincrBy("count_min_sketch", hash, 1);
        }
    }

    public int estimateFrequency(String element) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < numHashes; i++) {
            long hash = hash(element, i);
            int count = jedis.getbit("count_min_sketch", hash) ? 1 : 0;
            if (count < minCount) {
                minCount = count;
            }
        }
        return minCount;
    }

    private long hash(String element, int index) {
        long hash = (element.hashCode() ^ index) & 0x7fffffff; // 将哈希值转换为正数
        return hash % width; // 将哈希值限定在位图的宽度范围内
    }

    public static void main(String[] args) {
        CountMinSketchWithBitmap sketch = new CountMinSketchWithBitmap(4, 100);
        sketch.increment("apple");
        sketch.increment("banana");
        sketch.increment("apple");
        sketch.increment("orange");

        int appleCount = sketch.estimateFrequency("apple");
        System.out.println("Estimated frequency of 'apple': " + appleCount);

        int bananaCount = sketch.estimateFrequency("banana");
        System.out.println("Estimated frequency of 'banana': " + bananaCount);

        int orangeCount = sketch.estimateFrequency("orange");
        System.out.println("Estimated frequency of 'orange': " + orangeCount);
    }
}
