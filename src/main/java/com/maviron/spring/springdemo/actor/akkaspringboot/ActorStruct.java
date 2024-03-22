// package com.maviron.spring.springdemo.actor.akkaspringboot;
//
// import akka.actor.AbstractActor;
// import com.maviron.spring.springdemo.entity.User;
//
// ​
// /**
//  * 保护构造函数的演员
//  */
// public class ActorStruct extends AbstractActor {
//     private final User user;
// ​
//     public ActorStruct(User userModel){
//         this.user = userModel;
//     }
// ​
//     //处理消息
//     @Override
//     public Receive createReceive() {
//         //处理一个具体类型的消息，比如是字符串类型的消息
//         Receive build = receiveBuilder().match(String.class,(msg)-> {
//             System.out.println(msg);
//             sender().tell("我是ActorStruct返回结果", self());
//         }).match(Integer.class,(msg)-> {
//             System.out.println(msg+"1");
//         }).build();
//         return build;
//     }
// }