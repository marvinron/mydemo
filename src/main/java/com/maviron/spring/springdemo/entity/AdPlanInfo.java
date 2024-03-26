package com.maviron.spring.springdemo.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdPlanInfo {
    /**
     * 广告计划ID
     */
    private Integer planId;
    /**
     * 投放时间段
     */
    private int[] periods;
    /**
     * 日预算
     */
    private int dailyBudget;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public int[] getPeriods() {
        return periods;
    }

    public void setPeriods(int[] periods) {
        this.periods = periods;
    }

    public int getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(int dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public static void main(String[] args) {
        BigDecimal balance = new BigDecimal("3.44");
        BigDecimal bigDecimal = balance.setScale(1, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.toString());
    }


}