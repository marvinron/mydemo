package com.maviron.spring.springdemo.actor.akka.akkatest;

import java.io.Serializable;

// 响应消息类
public class ResponseMessage implements Serializable {
    // 响应消息的内容
    private String nessage;

    public String getNessage() {
        return nessage;
    }

    public void setNessage(String nessage) {
        this.nessage = nessage;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "nessage='" + nessage + '\'' +
                '}';
    }
}