package com.maviron.spring.springdemo.strategy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MessageContext.java
 * @Description 消息策略环境类
 * @createTime 2022年08月23日 09:50:00
 */
@Component
public class MessageContext {

    private static final Map<String, MessageStrategy> map = new HashMap<>(16);

    public MessageContext(List<MessageStrategy> messageStrategyList) {
        messageStrategyList.forEach(messageStrategy -> map.put(messageStrategy.getMessageType(), messageStrategy));
    }

    public MessageStrategy getMessageStrategy(String messageType) {
        MessageStrategy messageStrategy = map.get(messageType);
        if (messageStrategy == null) {
            throw new RuntimeException("message type is inValid");
        }
        return messageStrategy;
    }

}
