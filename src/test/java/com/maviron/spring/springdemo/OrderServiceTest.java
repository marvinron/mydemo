package com.maviron.spring.springdemo;

import com.maviron.spring.springdemo.event.orderevent.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderServiceTest.java
 * @Description 订单服务测试类
 * @createTime 2022年08月31日 15:53:00
 */
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void orderTest(){
        orderService.buyOrder("11020401011");
    }
}
