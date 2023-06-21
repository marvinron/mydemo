package com.maviron.spring.springdemo.entity;

import java.io.Serializable;


public class FlowResDTO implements Serializable {
    private static final long serialVersionUID = 4999293522811415524L;

    /**
     * 日期
     */
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "FlowResDTO{" +
                "day='" + day + '\'' +
                '}';
    }
}
