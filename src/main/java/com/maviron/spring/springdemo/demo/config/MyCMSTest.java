package com.maviron.spring.springdemo.demo.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.WeightRandom;
import com.maviron.spring.springdemo.until.WeightedRandomSelector;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.UUID;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyCMSTest.java
 * @createTime 2023年08月04日 09:51:00
 */
public class MyCMSTest {
    private final int numRows;
    private final int hashCount;
    private final Jedis jedis;

    public MyCMSTest(int numRows) {
        this.numRows = numRows;
        this.hashCount = 1;
        this.jedis = new Jedis("bj-crs-g007s5vu.sql.tencentcdb.com", 24708);
        jedis.auth("Gameley668");
        //jedis.select(5);
    }

    public void insertDevice(String orderId, String device) {
        long[] rows = hashFunctions(device);
        for (long row : rows) {
            jedis.hincrBy(orderId, String.valueOf(row), 1);
        }
    }

    public int estimateFrequency(String orderId, String element) {
        long[] rows = hashFunctions(element);
        int minFrequency = Integer.MAX_VALUE;
        for (long row : rows) {
            String frequency = jedis.hget(orderId, String.valueOf(row));
            if (frequency != null) {
                int freq = Integer.parseInt(frequency);
                minFrequency = Math.min(minFrequency, freq);
            }
        }
        return minFrequency;
    }

    private long[] hashFunctions(String element) {
        long[] rows = new long[hashCount];
        for (int i = 0; i < hashCount; i++) {
            rows[i] = (MurMurHashUtil.hash(element) + i) % numRows;
        }
        return rows;
    }

    public static void main(String[] args) {
        WeightRandom<String> weightRandom = new WeightRandom<>();
        //WeightedRandomSelector<String> weightSelector = new WeightedRandomSelector<>();
        long satrt = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            weightRandom.add("A",60);
            weightRandom.add("B",40);
            String next = weightRandom.next();
            //weightSelector.add(60,"A");
            //weightSelector.add(40,"B");
            //String next = weightSelector.select();
            System.out.println(next);
        }
        System.out.println((System.currentTimeMillis() - satrt));

        //String dateStr = "2023-08-10 12:30:25";
        //long time = DateUtil.parse(dateStr,"yyyy-MM-dd HH:mm:ss").getTime();
        //System.out.println(time);
    }
}
