package com.maviron.spring.springdemo.event.orderevent;

import cn.hutool.core.date.StopWatch;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderProductListener.java
 * @Description 订单事件监听器
 * @createTime 2022年08月31日 15:39:00
 */
//@Component
public class OrderProductListener{
    public void onApplicationEvent(OrderProductEvent event) {
        String orderId = event.getOrderId();
        StopWatch clock = new StopWatch();
        clock.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clock.stop();
        System.out.printf("校验商品订单 %s,耗时 %s 秒", orderId, clock.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        StopWatch clock = new StopWatch();
        clock.start("开始任务1");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clock.stop();
        System.out.println(clock.getLastTaskName()+"==="+clock.getTotalTimeMillis());
    }
}
