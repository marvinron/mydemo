package com.maviron.spring.springdemo.event.blackemail;

import org.springframework.context.ApplicationListener;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BlackListNotifier.java
 * @Description TODO
 * @createTime 2024年07月11日 11:38:00
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        //黑名单处理

    }
}
