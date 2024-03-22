package com.maviron.spring.springdemo.actor.akka.akkanew;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Actor2.java
 * @Description TODO
 * @createTime 2024年03月21日 09:48:00
 */
// public class Actor2 extends AbstractActor {
//     @Override
//     public Receive createReceive() {
//         return receiveBuilder()
//                 .match(String.class, message -> {
//                     System.out.println("Actor2 received: " + message);
//
//                     // 创建第三个actor
//                     ActorRef actor3 = getContext().actorOf(Props.create(Actor3.class));
//
//                     // 向第三个actor发送消息
//                     actor3.tell("Hello from Actor2", getSelf());
//                 })
//                 .build();
//     }
// }
