package com.maviron.spring.springdemo.entity;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

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




}