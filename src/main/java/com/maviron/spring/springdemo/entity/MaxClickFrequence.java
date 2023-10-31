package com.maviron.spring.springdemo.entity;

import java.io.Serializable;

/**
 * 最大点击频次
 */
public class MaxClickFrequence implements Serializable {


    private static final long serialVersionUID = 7692822853342946988L;
    private int maxLimit = 0;
    private int period = 0;

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxFreqLimit) {
        this.maxLimit = maxFreqLimit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
