package com.maviron.spring.springdemo.event.blackemail;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EmailService.java
 * @Description TODO
 * @createTime 2024年07月11日 11:37:00
 */
public class EmailService implements ApplicationEventPublisherAware {
    private List<String> blackList;
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blackList.contains(address)) {
            //发布黑名单事件
            publisher.publishEvent(new BlackListEvent(this, address, content));
            return;
        }
        // do send email...
    }
}
