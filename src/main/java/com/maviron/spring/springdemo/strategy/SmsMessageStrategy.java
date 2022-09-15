package com.maviron.spring.springdemo.strategy;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsMessageStrategy.java
 * @Description sms消息处理
 * @createTime 2022年08月23日 09:45:00
 */
@Service
public class SmsMessageStrategy implements MessageStrategy {
    @Override
    public String sendMessage() {
        return " SmsMessage send...";
    }

    @Override
    public String getMessageType() {
        return "SMS";
    }
}
