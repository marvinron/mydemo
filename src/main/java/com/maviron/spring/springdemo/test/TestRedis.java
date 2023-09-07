package com.maviron.spring.springdemo.test;

import cn.hutool.core.date.StopWatch;
import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.until.SerializeUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestRedis.java
 * @Description TODO
 * @createTime 2023年05月20日 14:46:00
 */
public class TestRedis {

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1000);
        config.setMaxIdle(100);
        config.setTestOnBorrow(false);
        config.setTestWhileIdle(false);
        config.setTestOnReturn(false);
        config.setMaxWaitMillis(100);
        JedisPool jedisPool = new JedisPool(config, "bj-crs-evk1h6lo.sql.tencentcdb.com", 27531, 1000, "Gameley668");
        StopWatch stopWatch = new StopWatch();
        Jedis jedis = jedisPool.getResource();
        stopWatch.start();
        //Boolean asdsadas12 = jedis.setbit("asdsadas12", 111111111, String.valueOf(1));
        //jedis.del("asdsadas12");
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("耗费时间是 " + totalTimeMillis);
        //System.out.println(asdsadas12);
        //Boolean asdsadas121 = jedis.getbit("asdsadas12", 111111111);
        //Long asdsadas122 = jedis.bitcount("asdsadas12");
        //System.out.println(asdsadas122);
        //System.out.println(asdsadas121);
        User user = new User();
        user.setId("8");
        user.setName("hello");
        user.setAge(18);
        jedis.set("123_user".getBytes(),SerializeUtil.serialize(user));
        int length = SerializeUtil.serialize(user).length;
        System.out.println(length);
        byte[] bytes = jedis.get("123_user".getBytes());
        User unserialize = (User) SerializeUtil.unserialize(bytes);
        System.out.println(unserialize);
        System.out.println(unserialize.toString().length());
        jedis.close();
        jedisPool.close();
    }
}
