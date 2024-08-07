package com.maviron.spring.springdemo.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.maviron.spring.springdemo.entity.AdPlanInfo;
import com.maviron.spring.springdemo.until.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AdPlanServiceImpl.java
 * @Description
 * @createTime 2022年04月19日 11:47:00
 */
@Service
public class AdPlanHourServiceImpl {

    @Autowired
    private RedisUtil redisUtil;
    public  boolean filter(AdPlanInfo adPlanInfo) {
        // 获取当前投放时段
        Calendar calendar = Calendar.getInstance();
        int currHour = calendar.get(Calendar.HOUR_OF_DAY);
        DateTime date = DateUtil.date();
        System.out.println(date + "当前时间开始========");
        String today = StringUtils.replace(DateUtil.today(), "-", "");
        // 获取当日总消耗
        int dailyConsumed = StringUtils.isEmpty(redisUtil.get("adplan_budget_day" + ":" + today)) ? 0 : Integer.parseInt(redisUtil.get("adplan_budget_day" + ":" + today));
        System.out.println(today + "当日总消耗====" + dailyConsumed);
        // 获取小时消耗
        int hourConsumed = StringUtils.isEmpty(redisUtil.get("adplan_budget_day" + ":" + today+":"+DateUtil.thisHour(true))) ? 0 : Integer.parseInt(redisUtil.get("adplan_budget_day" + ":" + today+":"+DateUtil.thisHour(true)));
        System.out.println(DateUtil.thisHour(true) + "当前小时消耗====" + hourConsumed);
        // 计算小时预算
        int hourBudget = computeHourBudget(currHour, adPlanInfo, dailyConsumed - hourConsumed);
        System.out.println((DateUtil.thisHour(true) + "当前小时预算====" + hourBudget));
        if (hourConsumed >= hourBudget) {
            return true;
        }
        return false;
    }

    private  int computeHourBudget(int currHour, AdPlanInfo adPlanInfo, int consumed) {
        int remainingHour = 0;
        int[] periods = adPlanInfo.getPeriods();
        for(int i=0;i<periods.length;i++) {
            if(periods[i]>=currHour) {
                remainingHour++;
            }
        }
        return (adPlanInfo.getDailyBudget() - consumed) / remainingHour;
    }
    //@Scheduled(cron = "0/10 * * * * ?")
    public void scheduledTask() {
        int[] periods = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        AdPlanInfo adPlanInfo = new AdPlanInfo();
        adPlanInfo.setPlanId(8889);
        adPlanInfo.setDailyBudget(10000);
        adPlanInfo.setPeriods(periods);
        boolean filter = filter(adPlanInfo);
        DateTime date = DateUtil.date();
        System.out.println("当前时间：" + date + filter);
    }

    public static void main(String[] args) {
        DateTime date = DateUtil.date();
        System.out.println(date);
        System.out.println(4*60);
    }
}
