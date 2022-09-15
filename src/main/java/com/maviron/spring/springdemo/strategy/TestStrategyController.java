package com.maviron.spring.springdemo.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description 策略测试类
 * @createTime 2022年08月23日 09:57:00
 */
@RestController
public class TestStrategyController {

    @Autowired
    private MessageContext messageContext;

    @RequestMapping("sendMessge")
    public String sendMessage(String messageType) {
        MessageStrategy messageStrategy = messageContext.getMessageStrategy(messageType);
        return messageStrategy.sendMessage();
    }
}
