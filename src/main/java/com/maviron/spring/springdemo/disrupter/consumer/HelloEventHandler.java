package com.maviron.spring.springdemo.disrupter.consumer;

import com.lmax.disruptor.EventHandler;
import com.maviron.spring.springdemo.disrupter.model.MessageModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HelloEventHandler.java
 * @Description eventHandler的消费者
 * @createTime 2022年06月27日 17:55:00
 */
@Slf4j
public class HelloEventHandler implements EventHandler<MessageModel> {
    @Override
    public void onEvent(MessageModel messageModel, long sequence, boolean endOfBatch) throws Exception {
        try {
            Thread.sleep(100);
            log.info("消费者消费消息开始");
            if (messageModel != null) {
                log.info("消费者消费的消息是{}", messageModel);
            }
        } catch (Exception e) {
            log.error("消费者消费异常");
        }
        log.info("消费者消费结束");
    }
}
