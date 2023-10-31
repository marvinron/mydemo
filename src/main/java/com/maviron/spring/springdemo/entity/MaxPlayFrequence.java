package com.maviron.spring.springdemo.entity;

import java.io.Serializable;

/**
 * 最大曝光频次
 */
public class MaxPlayFrequence implements Serializable {

    private static final long serialVersionUID = -8376001061429197668L;
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
