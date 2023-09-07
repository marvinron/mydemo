package com.maviron.spring.springdemo.redis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RedisUtil.java
 * @Description TODO
 * @createTime 2023年08月18日 11:54:00
 */
public class RedisUtil {
    private static JedisPool jedisPool = null;
    //如果赋值为-1，则表示不限制，如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
    private static Integer MAX_TOTAL = 10000;
    //控制一个pool最多有多少个状态为idle(空闲)的jedis实例，默认值是8
    private static Integer MAX_IDLE = 10000;
    //如果为true，则得到的jedis实例均是可用的
    private static Boolean TEST_ON_BORROW = false;
    //在空闲时检查有效性, 默认false
    private static Boolean TEST_WHILE_IDLE = false;
    //是否进行有效性检查
    private static Boolean TEST_ON_RETURN = false;
    //当资源耗尽时是否等待
    private static Boolean BLOCK_WHEN_EXHAUSTED = false;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_TOTAL);
        config.setMaxIdle(MAX_IDLE);
        config.setBlockWhenExhausted(BLOCK_WHEN_EXHAUSTED);
        config.setTestOnBorrow(TEST_ON_BORROW);
        config.setTestWhileIdle(TEST_WHILE_IDLE);
        config.setTestOnReturn(TEST_ON_RETURN);
        String redisUrl = "bj-crs-g007s5vu.sql.tencentcdb.com";
        String redisPort = "24708";
        String redisAuth = "Gameley668";
        int clusterTimeout = 5;
        jedisPool = new JedisPool(config, redisUrl, Integer.valueOf(redisPort), clusterTimeout, redisAuth);
    }
    /**
     * 对key设置过期时间
     *
     * @param key     CMS容器的key
     * @param value 经过多久过期 过期时间（秒）
     */
    public static void set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        } catch (Exception e) {
        }
    }

}
