package com.maviron.spring.springdemo.actor.akka;

import akka.actor.AbstractActor;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TaskManager.java
 * @Description TODO
 * @createTime 2023年07月14日 11:26:00
 */
public class TaskManager extends AbstractActor {
    @Override
    public Receive createReceive() {
        // 对所有的消息不做任何响应
        return receiveBuilder().build();
    }
}
