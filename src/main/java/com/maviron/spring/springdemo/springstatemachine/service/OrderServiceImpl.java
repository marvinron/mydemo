package com.maviron.spring.springdemo.springstatemachine.service;

import com.maviron.spring.springdemo.springstatemachine.OrderStatus;
import com.maviron.spring.springdemo.springstatemachine.OrderStatusChangeEvent;
import com.maviron.spring.springdemo.dao.AdsOrderBakDao;
import com.maviron.spring.springdemo.springstatemachine.entity.AdsOrderBak;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderServiceImpl.java
 * @Description OrderServiceImpl
 * @createTime 2024年02月19日 15:16:00
 */
@Slf4j
@Service("orderService")
public class OrderServiceImpl {
    /**
     * 状态机
     */
    @Resource
    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
    /**
     * 状态机持久化
     */
    @Resource
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, String> stateMachineMemPersister;
    @Resource
    private AdsOrderBakDao adsOrderBakDao;

    /**
     * 创建订单
     *
     * @param id
     * @return
     */
    public AdsOrderBak getOrderById(Integer id) {
        AdsOrderBak adsOrderBak = adsOrderBakDao.queryById(id);
        return adsOrderBak;
    }

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    public AdsOrderBak createOrder(AdsOrderBak order) {
        order.setStatus(OrderStatus.WAIT_PAYMENT.getKey());
        adsOrderBakDao.insert(order);
        return order;
    }

    /**
     * 支付订单
     *
     * @param id
     * @return
     */
    public AdsOrderBak pay(Integer id) {
        AdsOrderBak order = adsOrderBakDao.queryById(id);
        log.info("线程名称：{},尝试支付，订单号：{}", Thread.currentThread().getName(), id);
        if (!sendEvent(OrderStatusChangeEvent.PAYED, order)) {
            log.error("线程名称：{},支付失败, 状态异常，订单信息：{}", Thread.currentThread().getName(), order);
            throw new RuntimeException("支付失败, 订单状态异常");
        }
        return order;
    }

    /**
     * 对订单进行发货
     *
     * @param id
     * @return
     */
    public AdsOrderBak deliver(Integer id) {
        AdsOrderBak adsOrderBak = adsOrderBakDao.queryById(id);
        log.info("线程名称：{}，尝试发货，订单号：{}", Thread.currentThread().getName(), String.valueOf(id));
        if (!sendEvent(OrderStatusChangeEvent.DELIVERY, adsOrderBak)) {
            log.error("线程名称：{},发货失败, 状态异常，订单信息：{}", Thread.currentThread().getName(), adsOrderBak);
            throw new RuntimeException("发货失败，订单状态异常！");
        }
        return adsOrderBak;
    }

    public AdsOrderBak receive(Integer id) {
        AdsOrderBak adsOrderBak = adsOrderBakDao.queryById(id);
        log.info("线程名称：{},尝试收货，订单号：{}", Thread.currentThread().getName(), id);
        if (!sendEvent(OrderStatusChangeEvent.RECEIVED, adsOrderBak)) {
            log.error("线程名称：{},收货失败, 状态异常，订单信息：{}", Thread.currentThread().getName(), adsOrderBak);
            throw new RuntimeException("收货失败, 订单状态异常");
        }
        return adsOrderBak;
    }

    /**
     * 发送订单转换事件
     * synchronized 保证线程安全的
     *
     * @param changeEvent
     * @param adsOrderBak
     * @return
     */
    private synchronized boolean sendEvent(OrderStatusChangeEvent changeEvent, AdsOrderBak adsOrderBak) {
        boolean result = false;
        try {
            //启动状态机
            orderStateMachine.start();
            stateMachineMemPersister.restore(orderStateMachine, String.valueOf(adsOrderBak.getId()));
            Message<OrderStatusChangeEvent> message = MessageBuilder.withPayload(changeEvent).setHeader("order", adsOrderBak).build();
            result = orderStateMachine.sendEvent(message);
            //持久化状态机的状态
            stateMachineMemPersister.persist(orderStateMachine, String.valueOf(adsOrderBak.getId()));
        } catch (Exception e) {
            log.error("订单操作失败，{}", e);
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }

}
