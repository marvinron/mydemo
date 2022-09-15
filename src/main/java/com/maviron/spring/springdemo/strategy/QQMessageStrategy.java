package com.maviron.spring.springdemo.strategy;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName QQMessageStrategy.java
 * @Description QQ消息处理
 * @createTime 2022年08月23日 09:43:00
 */
@Service
public class QQMessageStrategy implements MessageStrategy {
    @Override
    public String sendMessage() {
        return "发送QQ消息...";
    }

    @Override
    public String getMessageType() {
        return "QQ";
    }
}
