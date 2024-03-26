package com.maviron.spring.springdemo.demo.bloomfilter;

import cn.hutool.core.util.HashUtil;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

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
        String modKey = "aaa";
        // String modKey = "a36cd140-db5d-11ee-8547-14dda951cbfa";
        long l = hashCodeMod(modKey);
        RBloomFilter<Object> mytest0705Filter = redissonClient.getBloomFilter("globalfiltera20240321"+"_"+l);
        //boolean add = mytest0705Filter.add("");
        //boolean flag = mytest0705Filter.contains(key);
        //System.out.println(flag);

        // mytest0705Filter.tryInit(10L, 0.09);
        // mytest0705Filter.expire(3L,TimeUnit.DAYS);
        // mytest0705Filter.add(modKey);

        boolean flag1 = mytest0705Filter.contains(modKey);
        System.out.println(flag1);
        //boolean flag1 = mytest0705Filter.contains("asdas3232_123456_1000012");
        //System.out.println(flag1);
        //long size = mytest0705Filter.getSize();
        //System.out.println(size);
        //String yyyyMMdd = StringUtils.replace(DateUtil.today(),"-","");
        //System.out.println(yyyyMMdd);
        //String key = String.join("_","12312","fghf");
        //System.out.println(key);
        //JSONArray json = new JSONArray();
        //json.add("10001229");
        //System.out.println(json.toString());
        //List<String> mediaDebugFlagList = JSONObject.parseArray(json.toString(), String.class);
        //System.out.println(mediaDebugFlagList.size());
        redissonClient.shutdown();

    }
    // public static void main(String[] args) throws Exception {
    //     String redis_cluster_url_bloom = "bj-crs-6yxxz364.sql.tencentcdb.com";
    //     String redis_cluster_port_bloom = "21327";
    //     Config config = new Config();
    //     config.useSingleServer().setAddress("redis://" + redis_cluster_url_bloom + ":" + redis_cluster_port_bloom);
    //     config.useSingleServer().setPassword("Gameley668");
    //     RedissonClient redissonClient = Redisson.create(config);
    //     for (int i = 0; i < 12; i++) {
    //         RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter("globalFilter20240305" + "_" + i);
    //         System.out.println(bloomFilter.delete());
    //         System.out.println(bloomFilter.tryInit(100000L, 0.05));
    //     }
    // }

    private static long hashCodeMod(String param) {
        long hashValue = HashUtil.mixHash(param);
        long mod = 12;
        long digit = Math.abs(hashValue) % mod;
        return digit;
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

    // private static RedissonClient getRedissonClient() {
    //    String auth = "Gameley668";
    //    String clusterUrl = "bj-crs-6yxxz364.sql.tencentcdb.com";
    //    String clusterPort = "21327";
    //    Config config = new Config();
    //    config.useSingleServer().setAddress("redis://" + clusterUrl + ":" + clusterPort);
    //    config.useSingleServer().setPassword(auth);
    //    return Redisson.create(config);
    // }
}
