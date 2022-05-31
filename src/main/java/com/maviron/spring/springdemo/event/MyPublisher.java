package com.maviron.spring.springdemo.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyPublisher.java
 * @Description TODO
 * @createTime 2022年04月15日 16:22:00
 */
@Component
public class MyPublisher implements ApplicationEventPublisherAware,ApplicationContextAware {
    private ApplicationContext applicationContext;
    private ApplicationEventPublisher applicationEventPublisher;
    private String args;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public void publishEvent(String args){
        System.out.println("我要发布消息了");
        MyEvent myEvent = new MyEvent(applicationContext);
        myEvent.setArgs(args);
        applicationEventPublisher.publishEvent(myEvent);
    }

}
