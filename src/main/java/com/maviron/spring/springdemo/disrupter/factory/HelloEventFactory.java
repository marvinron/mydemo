package com.maviron.spring.springdemo.disrupter.factory;

import com.lmax.disruptor.EventFactory;
import com.maviron.spring.springdemo.disrupter.model.MessageModel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HelloEventFactory.java
 * @Description 事件工厂
 * @createTime 2022年06月27日 17:53:00
 */
public class HelloEventFactory implements EventFactory<MessageModel> {
    @Override
    public MessageModel newInstance() {
        return new MessageModel();
    }
}
