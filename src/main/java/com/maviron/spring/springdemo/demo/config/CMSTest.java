package com.maviron.spring.springdemo.demo.config;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CMSTest.java
 * @Description TODO
 * @createTime 2023年08月04日 09:42:00
 */
public class CMSTest {
    private final int numRows;
    private final int numCols;
    private final Jedis jedis;

    public CMSTest(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.jedis = new Jedis("152.136.136.185", 8111);
        jedis.auth("Gameley668");
        jedis.select(7);

    }
    public void insertElement(String element) {
        int[] rows = {-2, -1, 0};
        for (int row : rows) {
            jedis.hincrBy("count_min_sketch", String.valueOf(row), 1);
        }
    }
    private int[] hashFunctions(String element) {
        int[] rows = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = (element.hashCode() + i) % numRows;
        }
        return rows;
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

    public static void main(String[] args) {
        //int[] rows = new int[3];
        //for (int i = 0; i < 3; i++) {
        //    rows[i] = ("wqwewq_12312".hashCode() + i) % 3;
        //}
        //System.out.println(Arrays.toString(rows));

        Jedis jedis = new Jedis("152.136.136.185", 8111);
        jedis.auth("Gameley668");
        jedis.select(7);

        int[] rows = {-2, -1, 0};
        //for (int row : rows) {
        //    jedis.hincrBy("count_min_sketch", String.valueOf(row), 1);
        //}

        //int[] rows = hashFunctions(element);
        int minFrequency = Integer.MAX_VALUE;
        for (int row : rows) {
            String frequency = jedis.hget("count_min_sketch", String.valueOf(row));
            if (frequency != null) {
                int freq = Integer.parseInt(frequency);
                minFrequency = Math.min(minFrequency, freq);
            }
        }
    }
}
