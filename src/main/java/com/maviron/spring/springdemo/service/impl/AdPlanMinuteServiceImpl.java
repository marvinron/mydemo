package com.maviron.spring.springdemo.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.maviron.spring.springdemo.entity.AdPlanInfo;
import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.until.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AdPlanServiceImpl.java
 * @Description
 * @createTime 2022年04月19日 11:47:00
 */
@Service
public class AdPlanMinuteServiceImpl {

    @Autowired
    private RedisUtil redisUtil;

    public boolean filter(AdPlanInfo adPlanInfo) {
        // 获取当前投放时段
        Calendar calendar = Calendar.getInstance();
        int currHour = calendar.get(Calendar.HOUR_OF_DAY);
        DateTime date = DateUtil.date();
        System.out.println(date + " 当前时间开始========");
        String today = StringUtils.replace(DateUtil.today(), "-", "");
        // 获取当日总消耗
        int dailyConsumed = StringUtils.isEmpty(redisUtil.get("adplan_budget_day" + ":" + today)) ? 0 : Integer.parseInt(redisUtil.get("adplan_budget_day" + ":" + today));
        System.out.println(today + " 当日总消耗====" + dailyConsumed);
        //获取当前分钟的消耗
        String minuteCostRedis = redisUtil.get("adplan_budget_day" + ":" + today + ":" + DateUtil.thisHour(true) + ":" + DateUtil.thisMinute());
        System.out.println(DateUtil.date() + " 当前分钟" + DateUtil.thisMinute() + "的消耗:" + minuteCostRedis);
        int minuteCost = StringUtils.isEmpty(minuteCostRedis) ? 0 : Integer.parseInt(minuteCostRedis);
        // 计算每分钟的预算
        int minuteBudget = computeHourBudget(currHour, adPlanInfo, dailyConsumed);
        System.out.println((DateUtil.thisMinute() + " 当前分钟预算====" + minuteBudget));
        if (minuteCost >= minuteBudget) {
            return true;
        }
        return false;
    }

    private int computeHourBudget(int currHour, AdPlanInfo adPlanInfo, int dailyConsumed) {
        int remainingHour = 0;
        int[] periods = adPlanInfo.getPeriods();
        for (int i = 0; i < periods.length; i++) {
            if (periods[i] >= currHour) {
                remainingHour++;
            }
        }
        return (adPlanInfo.getDailyBudget() - dailyConsumed) / (remainingHour * 60);
    }


    //@Scheduled(cron = "0/10 * * * * ?")
    public void scheduledTask() {
        int[] periods = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        AdPlanInfo adPlanInfo = new AdPlanInfo();
        adPlanInfo.setPlanId(8889);
        adPlanInfo.setDailyBudget(10000);
        adPlanInfo.setPeriods(periods);
        boolean filter = filter(adPlanInfo);
        DateTime date = DateUtil.date();
        System.out.println("当前时间：" + date + " " + filter);
    }

    public static void main(String[] args) {
        //DateTime date = DateUtil.date();
        //System.out.println(date);
        //System.out.println(4 * 60);
        //double randomNum = (Math.random() * 900) + 100;
        //System.out.println(randomNum);
        //int i = DateUtil.thisMinute();
        //System.out.println(i);
        //int i1 = DateUtil.dayOfWeek(new Date());
        //System.out.println(i1);
        //String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        //String format2 = DateFormatUtils.format(DateUtils.addDays(new Date(),10), "yyyy-MM-dd");
        //System.out.println(format);
        //System.out.println(format2);
        //long l = DateUtil.between(new Date(), DateUtils.addDays(new Date(), 10), DateUnit.DAY);
        //long l1 = l % 7;
        ////System.out.println(l1);
        //
        //for (int k = 0; k < l1; k++) {
        //    Date date = DateUtils.addDays(new Date(), 10);
        //    Date date1 = DateUtils.addDays(date, -k);
        //    System.out.println(date1);
        //    int i = DateUtil.dayOfWeek(date1);
        //    System.out.println(i);
        //}
        //
        //System.out.println(DateUtil.thisDayOfWeek());
        ////System.out.println(l1);
        ////System.out.println(l);
        //System.out.println(DateUtil.thisHour(true));
        //System.out.println("===================");
        //String json = "{\"planHour\":[{\"week\":7,\"hour\":[1,2,3,4,5]},{\"week\":2,\"hour\":[1,2,3,4,5]},{\"week\":3,\"hour\":[1,2,3,4,5]}]}";
        //JSONObject jsonObject = JSONObject.parseObject(json);
        //JSONArray planHour =
        //        jsonObject.getJSONArray("planHour");
        //for (int i = 0; i < planHour.size(); i++) {
        //    JSONObject jsonObject1 = planHour.getJSONObject(i);
        //    Integer week = jsonObject1.getInteger("week");
        //    System.out.println(week);
        //    JSONArray hour = jsonObject1.getJSONArray("hour");
        //    System.out.println(hour);
        //    boolean contains = hour.contains(5);
        //    System.out.println(contains);
        //
        //
        //}
        //System.out.println("+++++++++++++++++++++++");
        //int i = DateUtil.thisMinute();
        //System.out.println(i);
        //int i1 = 5 * 10 - i;
        //System.out.println(i1);
        //System.out.println("------------------------");
        //String today = DateUtil.today();
        //System.out.println(today);
        Map<String, List<User>> map = new HashMap<>();
        List<User> list1 = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setName("dabai");
        user.setAge(18);
        list1.add(user);
        //map.put("haha", list1);


        //List<User> list2 = new ArrayList<>();
        User user1 = new User();
        user1.setId("1");
        user1.setName("dabai");
        user1.setAge(18);
        list1.add(user1);
        //map.put("hihi", list2);
        //System.out.println(map);

        List<User> collect = list1.stream().map(user2 -> doAgeUser(user2)).collect(Collectors.toList());
        System.out.println(collect);


    }

    private static User doAgeUser(User user2) {
        user2.setAge(28);
        return user2;
    }
}
