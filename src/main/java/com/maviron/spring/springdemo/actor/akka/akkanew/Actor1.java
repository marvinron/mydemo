package com.maviron.spring.springdemo.actor.akka.akkanew;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.pattern.Patterns;
import scala.concurrent.Future;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Actor1.java
 * @Description TODO
 * @createTime 2024年03月21日 09:47:00
 */
// public class Actor1 extends AbstractActor {
//     @Override
//     public Receive createReceive() {
//         return receiveBuilder()
//                 .match(String.class, message -> {
//                     System.out.println("Actor1 received: " + message);
//
//                     // 创建第二个actor
//                     ActorRef actor2 = getContext().actorOf(Props.create(Actor2.class));
//
//                     // 使用ask操作向第二个actor发送消息，并等待返回结果
//                     Future<Object> future = Patterns.ask(actor2, "Hello from Actor1", 5000);
//                     future.onComplete(response -> {
//                         if (response.isSuccess()) {
//                             getSender().tell(response.get(), getSelf());
//                         } else {
//                             getSender().tell("Failed to receive response from Actor2", getSelf());
//                         }
//                         return response;
//                     }, getContext().getSystem().dispatcher());
//                 })
//                 .build();
//     }
// }
