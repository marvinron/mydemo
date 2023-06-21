package com.maviron.spring.springdemo.demo.limit;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.NumberUtil;
import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RedissionLimiter.java
 * @Description 使用Redission限流
 * @createTime 2023年06月01日 09:48:00
 */
public class RedissionLimiter {
    //private static RRateLimiter rateLimiter = null;

    private static Logger logger = LoggerFactory.getLogger(RedissionLimiter.class);


    public static void main(String[] args) {
        try{

            RedissonClient redissonClient = getRedissonClient();
            StopWatch clock = new StopWatch();
            clock.start();
            RRateLimiter rateLimiter = redissonClient.getRateLimiter("mytest-limiter-8");
            if(!rateLimiter.isExists()) {
                rateLimiter.trySetRate(RateType.OVERALL, new BigDecimal("2").longValue(), 1, RateIntervalUnit.SECONDS);
            }
            //rateLimiter.expire(24,TimeUnit.HOURS);
            rateLimiter.expireAtAsync(DateUtil.endOfDay(new Date()));
            boolean b = rateLimiter.tryAcquire();
            clock.stop();
            System.out.println("获取允许的时长是：" + clock.getTotalTimeMillis() + "是否获取了允许许可：" + b);
            //for (int i = 0; i < 10; i++) {
            //}
            //rateLimiter.delete();
            redissonClient.shutdown();
            Map<String, String> adPositionMap = new ConcurrentHashMap<>();
            adPositionMap.put("asd","1");
            adPositionMap.put("bgf","2");
            adPositionMap.put("wqw","3");
            adPositionMap.putAll(null);
            System.out.println(adPositionMap.size());
        }catch (Exception e){
            logger.error("出现异常：{},",e.getMessage(),e);
        }


        //String startTime = "23:55:00";
        //String endTime = "00:21:00";
        ////boolean timeRange = isTimeRange(startTime, endTime);
        ////System.out.println(timeRange);
        //boolean b = belongCalendar(new Date(), startTime, endTime);
        //System.out.println(b);

    }
    private static RedissonClient getRedissonClient(){
        String auth = "Gameley668";
        String clusterUrl = "bj-crs-evk1h6lo.sql.tencentcdb.com";
        String clusterPort = "27531";
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + clusterUrl + ":" + clusterPort);
        config.useSingleServer().setPassword(auth);
        config.useSingleServer().setDatabase(3);
        return Redisson.create(config);
    }

    public static boolean isTimeRange(String startTime, String endTime) {
        DateTime now = cn.hutool.core.date.DateUtil.parse(cn.hutool.core.date.DateUtil.format(new Date(), "HH:mm:ss"), "HH:mm:ss");
        DateTime start = cn.hutool.core.date.DateUtil.parse(startTime, "HH:mm:ss");
        DateTime end = cn.hutool.core.date.DateUtil.parse(endTime, "HH:mm:ss");
        return DateUtil.isIn(now, start, end);
    }




}
