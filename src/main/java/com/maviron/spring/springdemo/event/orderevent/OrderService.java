package com.maviron.spring.springdemo.event.orderevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description 订单服务
 * @createTime 2022年08月31日 15:50:00
 */
@Slf4j
@Service("orderService")
public class OrderService {
    private final ApplicationContext applicationContext;

    public OrderService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    /**
     * 下单
     *
     * @param orderId 订单ID
     */
    public String buyOrder(String orderId) {
        long start = System.currentTimeMillis();
        // 1.查询订单详情

        // 2.检验订单价格 （同步处理）
        applicationContext.publishEvent(new OrderProductEvent(this, orderId));

        // 3.短信通知（异步处理）

        long end = System.currentTimeMillis();
        log.info("任务全部完成，总耗时：({})毫秒", end - start);
        return "购买成功";
    }
}
