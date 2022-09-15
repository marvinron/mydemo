package com.maviron.spring.springdemo.strategy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MessageStrategy.java
 * @Description 策略模式接口
 * @createTime 2022年08月23日 09:41:00
 */
public interface MessageStrategy {
    /**
     * 发送消息
     * @return
     */
    String sendMessage();

    /**
     * 获取消息类型
     * @return
     */
    String getMessageType();
}
