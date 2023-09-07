package com.maviron.spring.springdemo.demo.cukoofilter;

import cn.hutool.core.date.StopWatch;
import redis.clients.jedis.JedisPooled;

import java.net.InetAddress;
import java.net.URI;
import java.util.UUID;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CukooFilter.java
 * @Description TODO
 * @createTime 2023年08月02日 11:21:00
 */
public class CukooFilter {
    public static void main(String[] args) throws Exception {
        //String deviceId = UUID.randomUUID().toString().replace("-", "").substring(0,16);
        //System.out.println(deviceId);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String hostName = InetAddress.getLocalHost().getHostName();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时 "+(end - start));
    }

    private static void getRedissonClient() throws Exception {
        JedisPooled jedisPooled = new JedisPooled(new URI("redis://bj-crs-evk1h6lo.sql.tencentcdb.com:27531"), 1000000);
        //jedisPooled.pexpire()
        String freqency_orderId = jedisPooled.cmsInitByDim("freqency_orderId", 1000000, 2);
        //jedisPooled.cmsInitByProb()
        //String frequency = jedisPooled.cfReserve("frequency", 10000000);
        //jedisPooled.cfAdd("frequency", "123asdasd");
        //long frequency1 = jedisPooled.cfCount("frequency", "123asdasd");
        //System.out.println(frequency + "计数：" + frequency1);
        //jedisPooled.pfadd()
    }
}
