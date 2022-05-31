package com.maviron.spring.springdemo.design.observer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderObserverImpl.java
 * @Description 订单更新服务
 * @createTime 2022年04月25日 10:59:00
 */
public class OrderObserverImpl implements Observer {
    @Override
    public void notify(String orderNo) {
        System.out.printf("订单[%s]通知已更新\n",orderNo);
    }
}
