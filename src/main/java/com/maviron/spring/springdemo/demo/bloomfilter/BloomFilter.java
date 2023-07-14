package com.maviron.spring.springdemo.demo.bloomfilter;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.Date;
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
        RBloomFilter<Object> mytest0705Filter = redissonClient.getBloomFilter("posNoFillFilter20230713");
        mytest0705Filter.tryInit(800000000L, 0.09);
        mytest0705Filter.add("60000063_cff24b2952525b3c");
        mytest0705Filter.expire(1L,TimeUnit.HOURS);
        //boolean flag = mytest0705Filter.contains("asdas3232_123456_100001");
        //System.out.println(flag);
        //boolean flag1 = mytest0705Filter.contains("asdas3232_123456_1000012");
        //System.out.println(flag1);
        //long size = mytest0705Filter.getSize();
        //System.out.println(size);
        //String yyyyMMdd = StringUtils.replace(DateUtil.today(),"-","");
        //System.out.println(yyyyMMdd);
        //String key = String.join("_","12312","fghf");
        //System.out.println(key);
        redissonClient.shutdown();
    }
    private static RedissonClient getRedissonClient() {
        String auth = "Gameley668";
        String clusterUrl = "bj-crs-evk1h6lo.sql.tencentcdb.com";
        String clusterPort = "27531";
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + clusterUrl + ":" + clusterPort);
        config.useSingleServer().setPassword(auth);
        //config.useSingleServer().setDatabase(3);
        return Redisson.create(config);
    }
}
