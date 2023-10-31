package com.maviron.spring.springdemo.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class FrequenceLimit implements Serializable {
    private static final long serialVersionUID = -6432515240940352742L;
    //最大请求频次
    private MaxReqFrequence maxReqFrequence;
    //最大曝光频次
    private MaxPlayFrequence maxPlayFrequence;
    //最大点击频次
    private MaxClickFrequence maxClickFrequence;

    public MaxReqFrequence getMaxReqFrequence() {
        return maxReqFrequence;
    }

    public void setMaxReqFrequence(MaxReqFrequence maxReqFrequence) {
        this.maxReqFrequence = maxReqFrequence;
    }

    public MaxPlayFrequence getMaxPlayFrequence() {
        return maxPlayFrequence;
    }

    public void setMaxPlayFrequence(MaxPlayFrequence maxPlayFrequence) {
        this.maxPlayFrequence = maxPlayFrequence;
    }

    public MaxClickFrequence getMaxClickFrequence() {
        return maxClickFrequence;
    }

    public void setMaxClickFrequence(MaxClickFrequence maxClickFrequence) {
        this.maxClickFrequence = maxClickFrequence;
    }

    public static void main(String[] args) {
        FrequenceLimit frequenceLimit = JSONObject.parseObject("", FrequenceLimit.class);
        System.out.println(frequenceLimit);
    }
}