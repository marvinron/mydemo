package com.maviron.spring.springdemo.event.blackemail;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent {
    public String address;
    public String content;

    public BlackListEvent(Object source,String address,String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }
}