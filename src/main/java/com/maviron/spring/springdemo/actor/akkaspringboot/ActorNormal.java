// package com.maviron.spring.springdemo.actor.akkaspringboot;
//
// import akka.actor.AbstractActor;
// ​
// public class ActorNormal extends AbstractActor {​
//     //处理消息
//     @Override
//     public Receive createReceive() {
//         //处理一个具体类型的消息，比如是字符串类型的消息
//         Receive build = receiveBuilder().match(String.class,(msg)-> {
//             System.out.println(msg);
//             rightactorsender().tell("response", self());
//         }).match(Integer.class,(msg)-> {
//             System.out.println(msg+"1");
//         }).build();
//         return build;
//     }
// }