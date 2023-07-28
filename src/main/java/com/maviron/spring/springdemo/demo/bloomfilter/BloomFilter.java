package com.maviron.spring.springdemo.demo.bloomfilter;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

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
        RBloomFilter<Object> mytest0705Filter = redissonClient.getBloomFilter("posNoFillFilter20230727");
        //mytest0705Filter.tryInit(800000000L, 0.09);
        //mytest0705Filter.add("5f60541dfc654605a874ce0986c13ac5_oaid_ED7A268548E2");
        //mytest0705Filter.expire(1L,TimeUnit.HOURS);
        boolean flag = mytest0705Filter.contains("30001252_BC78D0B9-76F7-421C-A8DC-564C796E15BD");
        System.out.println(flag);
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
