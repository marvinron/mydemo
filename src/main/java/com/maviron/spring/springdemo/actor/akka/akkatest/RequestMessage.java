package com.maviron.spring.springdemo.actor.akka.akkatest;

import java.io.Serializable;

// 请求消息类
public class RequestMessage implements Serializable {
    // 请求消息的内容
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
