package com.maviron.spring.springdemo.demo.bloomfilter;

import cn.hutool.core.util.HashUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.List;

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
        String key = "f4c91c39ce8d48da83b27c16fea8344d_oaid_03944670-47a9-4ae6-ab67-a98030f490ed";
        long l = hashCodeMod(key);
        RBloomFilter<Object> mytest0705Filter = redissonClient.getBloomFilter("f4c91c39ce8d48da83b27c16fea8344d"+"_"+l);
        boolean add = mytest0705Filter.add("");
        boolean flag = mytest0705Filter.contains(key);
        System.out.println(flag);
        //mytest0705Filter.tryInit(100000000L, 0.09);
        //mytest0705Filter.add(key);
        //mytest0705Filter.expire(1L,TimeUnit.DAYS);

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
        //JSONArray json = new JSONArray();
        //json.add("10001229");
        //System.out.println(json.toString());
        //List<String> mediaDebugFlagList = JSONObject.parseArray(json.toString(), String.class);
        //System.out.println(mediaDebugFlagList.size());

    }

    private static long hashCodeMod(String param) {
        long hashValue = HashUtil.mixHash(param);
        long mod = 16;
        long digit = Math.abs(hashValue) % mod;
        return digit;
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
