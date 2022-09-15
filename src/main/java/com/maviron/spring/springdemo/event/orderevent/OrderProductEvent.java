package com.maviron.spring.springdemo.event.orderevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderProductEvent.java
 * @Description 订单事件
 * @createTime 2022年08月31日 10:03:00
 */
public class OrderProductEvent extends ApplicationEvent {
    /**
     * 该类型事件所携带的信息
     */
    private String orderId;

    public OrderProductEvent(Object source,String orderId) {
        super(source);
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
