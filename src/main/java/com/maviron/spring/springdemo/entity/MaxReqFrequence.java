package com.maviron.spring.springdemo.entity;

import java.io.Serializable;

/**
 * 最大请求频次
 */
public class MaxReqFrequence implements Serializable {
    private static final long serialVersionUID = -4465131220703357567L;
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
