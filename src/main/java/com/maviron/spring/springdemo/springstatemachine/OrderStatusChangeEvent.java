package com.maviron.spring.springdemo.springstatemachine;

/**
 * 事件
 */
public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED;
}
