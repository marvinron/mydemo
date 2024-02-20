package com.maviron.spring.springdemo.springstatemachine;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderStateMachineConfig.java
 * @Description 定义状态机规则和配置状态机
 * @createTime 2024年02月19日 10:01:00
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {
    /**
     * 配置状态
     *
     * @param states
     */
    @SneakyThrows
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states) {
        states
                .withStates()
                .initial(OrderStatus.WAIT_PAYMENT)
                .states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 配置状态转换事件
     *
     * @param transitions
     */
    @SneakyThrows
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions) {
        transitions
                //待支付->待发货
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                //待发货->待收货
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                //待收货->已完成
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISHED).event(OrderStatusChangeEvent.RECEIVED);
    }


}
