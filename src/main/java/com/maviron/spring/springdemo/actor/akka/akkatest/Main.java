package com.maviron.spring.springdemo.actor.akka.akkatest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        // 创建Actor系统
        ActorSystem system = ActorSystem.create("MySystem");

        // 创建Actor实例
        ActorRef actor1 = system.actorOf(Props.create(Actor1.class), "actor1");

        // 发送请求消息到actor1
        actor1.tell(new RequestMessage(), ActorRef.noSender());
    }
}
