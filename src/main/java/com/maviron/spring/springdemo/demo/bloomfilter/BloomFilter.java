package com.maviron.spring.springdemo.demo.bloomfilter;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BloomFilter.java
 * @Description TODO
 * @createTime 2023年07月05日 11:38:00
 */
public class BloomFilter {
    public static void main(String[] args) {
        RedissonClient redissonClient = getRedissonClient();
        //RBloomFilter<Object> mytest0705Filter = redissonClient.getBloomFilter("淘宝-点击人群-1200w（oaid+imei）-8.17");
        ////mytest0705Filter.tryInit(100000000L, 0.09);
        ////mytest0705Filter.add("123456_oaid_344CB49E7BE24AD8B5976366A931311816a7e51672217d08123cebc303fe7f83");
        ////mytest0705Filter.expire(1L,TimeUnit.HOURS);
        //boolean flag = mytest0705Filter.contains("b03ed75dced94621b2fbb3b5c95a00f3_imei_869096037044839");
        //System.out.println(flag);
        //boolean flag1 = mytest0705Filter.contains("5f60541dfc654605a874ce0986c13ac5_oaid_ED7A268548E200");
        //System.out.println(flag1);
        //boolean flag1 = mytest0705Filter.contains("asdas3232_123456_1000012");
        //System.out.println(flag1);
        //long size = mytest0705Filter.getSize();
        //System.out.println(size);
        //String yyyyMMdd = StringUtils.replace(DateUtil.today(),"-","");
        //System.out.println(yyyyMMdd);
        //String key = String.join("_","12312","fghf");
        //System.out.println(key);
        long start = System.currentTimeMillis();
        RRateLimiter rateLimiter = redissonClient.getRateLimiter("123456");
        if (rateLimiter.isExists() && !Objects.equals(Long.parseLong("2000"), rateLimiter.getConfig().getRate())) {
            redissonClient.getRateLimiter("123456").delete();
        }
        if (!rateLimiter.isExists()) {
            rateLimiter.trySetRate(RateType.OVERALL, Long.parseLong("2000"), 1, RateIntervalUnit.SECONDS);
        }
        boolean b = rateLimiter.tryAcquire();
        long end = System.currentTimeMillis();
        System.out.println("耗时 "+(end - start));
        redissonClient.shutdown();
    }
    //private static RedissonClient getRedissonClient() {
    //    String auth = "Gameley668";
    //    String clusterUrl = "bj-crs-evk1h6lo.sql.tencentcdb.com";
    //    String clusterPort = "27531";
    //    Config config = new Config();
    //    config.useSingleServer().setAddress("redis://" + clusterUrl + ":" + clusterPort);
    //    config.useSingleServer().setPassword(auth);
    //    //config.useSingleServer().setDatabase(3);
    //    return Redisson.create(config);
    //}

    private static RedissonClient getRedissonClient() {
        String auth = "Gameley668";
        String clusterUrl = "bj-crs-934sdw1s.sql.tencentcdb.com";
        String clusterPort = "22022";
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + clusterUrl + ":" + clusterPort);
        config.useSingleServer().setPassword(auth);
        return Redisson.create(config);
    }
}
