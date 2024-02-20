package com.maviron.spring.springdemo.springstatemachine;

import com.maviron.spring.springdemo.dao.AdsOrderBakDao;
import com.maviron.spring.springdemo.springstatemachine.entity.AdsOrderBak;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderStateListenerImpl.java
 * @Description 监听状态的变化
 * @createTime 2024年02月20日 09:40:00
 */
@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
@Slf4j
public class OrderStateListenerImpl {
    @Resource
    private AdsOrderBakDao adsOrderBakDao;

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public void payTransaction(Message<OrderStatusChangeEvent> message) {
        AdsOrderBak adsOrderBak = (AdsOrderBak) message.getHeaders().get("order");
        log.info("支付，状态机反馈信息：{}", message.getHeaders().toString());
        adsOrderBak.setStatus(OrderStatus.WAIT_DELIVER.getKey());
        adsOrderBakDao.update(adsOrderBak);
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public void deliverTransition(Message<OrderStatusChangeEvent> message) {
        AdsOrderBak adsOrderBak = (AdsOrderBak) message.getHeaders().get("order");
        log.info("发货，状态机反馈信息：{}", message.getHeaders().toString());
        adsOrderBak.setStatus(OrderStatus.WAIT_RECEIVE.getKey());
        adsOrderBakDao.update(adsOrderBak);
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public void receiveTransition(Message<OrderStatusChangeEvent> message) {
        AdsOrderBak adsOrderBak = (AdsOrderBak) message.getHeaders().get("order");
        log.info("收货，状态机反馈的信息：{}", message.getHeaders().toString());
        adsOrderBak.setStatus(OrderStatus.FINISHED.getKey());
        adsOrderBakDao.update(adsOrderBak);
    }
}
