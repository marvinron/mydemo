package com.maviron.spring.springdemo.disrupter.producer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DisruptorMqService.java
 * @Description Disruptor的生产者
 * @createTime 2022年06月27日 18:18:00
 */
public interface DisruptorMqService {
    /**
     * 生产者
     *
     * @param message
     */
    void sayHelloMq(String message);
}
