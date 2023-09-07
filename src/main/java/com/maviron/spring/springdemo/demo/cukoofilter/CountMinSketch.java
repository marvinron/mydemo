package com.maviron.spring.springdemo.demo.cukoofilter;

import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisClientConfig;

public class CountMinSketch {

    private final int numRows;
    private final int numCols;
    private final Jedis jedis;

    public CountMinSketch(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.jedis = new Jedis("152.136.136.185", 8111);
        jedis.auth("Gameley668");
        jedis.select(5);

    }

    public void insertElement(String element) {
        int[] rows = hashFunctions(element);
        int[] cols = hashFunctions(element, numCols);
        for (int i = 0; i < numRows; i++) {
            jedis.hincrBy("count_min_sketch", String.valueOf(rows[i]) + ":" + String.valueOf(cols[i]), 1);
        }
    }


    public int estimateFrequency(String element) {
        int[] rows = hashFunctions(element);
        int[] cols = hashFunctions(element, numCols);
        int minFrequency = Integer.MAX_VALUE;
        for (int i = 0; i < numRows; i++) {
            String frequency = jedis.hget("count_min_sketch", String.valueOf(rows[i]) + ":" + String.valueOf(cols[i]));
            if (frequency != null) {
                int freq = Integer.parseInt(frequency);
                minFrequency = Math.min(minFrequency, freq);
            }
        }
        return minFrequency;
    }


    private int[] hashFunctions(String element) {
        int[] rows = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = (element.hashCode() + i) % numRows;
        }
        return rows;
    }
    private int[] hashFunctions(String element, int numCols) {
        int[] cols = new int[numCols];
        for (int i = 0; i < numCols; i++) {
            cols[i] = (element.hashCode() + i) % numCols;
        }
        return cols;
    }


    public static void main(String[] args) {
        CountMinSketch cms = new CountMinSketch(1, 1);
        cms.insertElement("apple");
        cms.insertElement("banana");
        cms.insertElement("apple");
        cms.insertElement("apple1");
        cms.insertElement("apple");
        cms.insertElement("apple2");
        cms.insertElement("apple");
        cms.insertElement("apple3");
        cms.insertElement("apple4");
        cms.insertElement("apple6");
        cms.insertElement("apple7");
        cms.insertElement("appl4e");
        cms.insertElement("apple3");
        cms.insertElement("apple2");
        cms.insertElement("apple2");
        cms.insertElement("apple");
        cms.insertElement("apple");
        cms.insertElement("apple");
        cms.insertElement("apple");
        cms.insertElement("apple");
        int appleFreq = cms.estimateFrequency("apple");
        int bananaFreq = cms.estimateFrequency("banana");
        System.out.println("Frequency of apple: " + appleFreq);
        System.out.println("Frequency of banana: " + bananaFreq);
    }
}
