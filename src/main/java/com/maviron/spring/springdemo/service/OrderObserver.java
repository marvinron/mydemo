package com.maviron.spring.springdemo.service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderObserver.java
 * @Description 观察者接口
 * @createTime 2023年01月29日 16:33:00
 * //延迟消息
 */
public interface OrderObserver {
    void afterPlaceOrder();
}
