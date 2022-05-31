package com.maviron.spring.springdemo.quartz;

import cn.hutool.core.date.DateUtil;
import com.maviron.spring.springdemo.until.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AdPlanQuartz.java
 * @Description 广告计划定时任务
 * @createTime 2022年04月19日 11:16:00
 */
@Component
public class AdPlanQuartz {
    @Autowired
    private RedisUtil redisUtil;

    @Scheduled(cron = "0/1 * * * * ?")
    @PostConstruct
    public void updateAdPlanBudget() {

        String today = StringUtils.replace(DateUtil.today(), "-", "");
        //当日总消耗
        redisUtil.incrAtExpire("adplan_budget_day" + ":" + today, DateUtil.endOfDay(new Date()).getTime());
        //当前小时的消耗
        redisUtil.incrAtExpire("adplan_budget_day" + ":" + today + ":" + DateUtil.thisHour(true), DateUtil.endOfDay(new Date()).getTime());
        //当前分钟的消耗
        redisUtil.incrAtExpire("adplan_budget_day" + ":" + today + ":" + DateUtil.thisHour(true) + ":" + DateUtil.thisMinute(), DateUtil.endOfDay(new Date()).getTime());
    }
}
