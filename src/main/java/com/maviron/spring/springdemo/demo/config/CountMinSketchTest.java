package com.maviron.spring.springdemo.demo.config;

import redis.clients.jedis.Jedis;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CountMinSketchTest.java
 * @Description TODO
 * @createTime 2023年08月03日 20:58:00
 */
public class CountMinSketchTest {

    private final int numRows;
    private final int numCols;
    private final Jedis jedis;

    public CountMinSketchTest(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.jedis = new Jedis("bj-crs-evk1h6lo.sql.tencentcdb.com", 27531);
        jedis.auth("Gameley668");
        jedis.select(5);

    }

    public void insertElement(String element) {
        int[] rows = hashFunctions(element);
        for (int row : rows) {
            jedis.hincrBy("count_min_sketch", String.valueOf(row), 1);
        }
    }

    public int estimateFrequency(String element) {
        int[] rows = hashFunctions(element);
        int minFrequency = Integer.MAX_VALUE;
        for (int row : rows) {
            String frequency = jedis.hget("count_min_sketch", String.valueOf(row));
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

    public static void main(String[] args) {
        CountMinSketchTest cms = new CountMinSketchTest(1, 1);
        cms.insertElement("apple");
        cms.insertElement("banana");
        cms.insertElement("apple");
        int appleFreq = cms.estimateFrequency("apple");
        int bananaFreq = cms.estimateFrequency("banana");
        System.out.println("Frequency of apple: " + appleFreq);
        System.out.println("Frequency of banana: " + bananaFreq);
        //int[] rows = new int[3];
        //for (int i = 0; i < 3; i++) {
        //    rows[i] = ("wqwewq_12312".hashCode() + i) % 3;
        //}
        //System.out.println(Arrays.toString(rows));
        //for (int j = 0; j < 100; j++) {
        //    int[] rows = new int[3];
        //    for (int i = 0; i < 3; i++) {
        //        rows[i] = (UUID.randomUUID().toString().replace("-", "").hashCode() + i) % 10000000;
        //    }
        //    System.out.println(Arrays.toString(rows));
        //}
    }
}
