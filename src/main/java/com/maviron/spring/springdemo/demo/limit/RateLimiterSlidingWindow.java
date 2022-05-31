package com.maviron.spring.springdemo.demo.limit;

import java.math.BigDecimal;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RateLimiterSlidingWindow.java
 * @Description 滑动窗口算法
 * @createTime 2022年03月17日 12:27:00
 */
public class RateLimiterSlidingWindow {
    //阈值
    private int qps = 2;
    //时间窗口总大小
    private long windoSize = 1000;
    //滑动窗口的个数
    private Integer windoCount = 10;

    public static void main(String[] args) {
        boolean b = new BigDecimal(50000).compareTo(new BigDecimal(500000)) <= 0;
        System.out.println(b);
    }

}

 class WindowInfo {
    //窗口开始时间
    private long time;

}
