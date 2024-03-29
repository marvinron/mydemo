package com.maviron.spring.springdemo.ifdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    UN_PAID("1","订单未支付"),
    PAIDED("2","订单已支付"),
    SENDED("3","订单已发货"),
    SINGED("4","订单已签收"),
    EVALUATED("5","订单已评价");

    private String status;

    private String statusDes;

    static OrderStatusEnum of(String status) {
        for (OrderStatusEnum statusEnum : OrderStatusEnum.values()) {
            if (statusEnum.getStatus().equals(status)) {
                return statusEnum;
            }
        }
        return null;
    }
}