package com.maviron.spring.springdemo.strategy;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName WeChatStrategy.java
 * @Description 发送微信消息
 * @createTime 2022年08月23日 09:46:00
 */
@Service
public class WeChatStrategy implements MessageStrategy{
    @Override
    public String sendMessage() {
        return "weChat send message.....";
    }

    @Override
    public String getMessageType() {
        return "WeChat";
    }
}
