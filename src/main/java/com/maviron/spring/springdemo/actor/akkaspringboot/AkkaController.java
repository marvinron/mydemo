// package com.maviron.spring.springdemo.actor.akkaspringboot;
// ​
// import akka.actor.ActorRef;
// import akka.actor.ActorSystem;
// import akka.actor.Props;
// import akka.pattern.Patterns;
// import akka.util.Timeout;
// import com.maviron.spring.springdemo.entity.User;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import scala.concurrent.Await;
// import scala.concurrent.Future;
// import scala.concurrent.duration.Duration;
// ​
// import java.util.concurrent.TimeUnit;
// ​
// @RestController
// public class AkkaController {
// ​
//     @GetMapping(value = "/Akka/AkkaSendString")
//     @ResponseBody
//     // @ApiOperation(value = "Akka使用tell发送字符串", notes = "发送数值", httpMethod = "Get")
//     public void AkkaSendString() {
// ​
//         //创建所有管理actor的系统管理对象
//         ActorSystem actorSystem = ActorSystem.create();
// ​
//         //通过这个系统管理对象创建actor，并返回当前actor的地址，可以理解成现实生活中用户的一个邮箱地址
//         //使用actorSystem.actorOf定义一个名为actorNormal的ActorRef
//         ActorRef actor = actorSystem.actorOf(Props.create(ActorNormal.class), "actorNormal");
//         //发送消息Object msg（发送消息的内容，任何类型的数据）, final ActorRef rightactorsender（表示没有发送者（其实是一个叫做deadLetters的Actor））
//         actor.tell("kiba", ActorRef.noSender());
//     }
//     @GetMapping(value = "/Akka/AkkaSendInt")
//     @ResponseBody
//     // @ApiOperation(value = "Akka使用tell发送数值", notes = "发送数值", httpMethod = "Get")
//     public void AkkaSendInt() {
// ​
//         ActorSystem actorSystem = ActorSystem.create();
//         ActorRef actor = actorSystem.actorOf(Props.create(ActorNormal.class), "actorNormal");
//         actor.tell(518, ActorRef.noSender());//发送数值
//     }
// ​
//     @GetMapping(value = "/Akka/AkkaAsk")
//     @ResponseBody
//     // @ApiOperation(value = "Akka使用Ask请求", notes = "Ask请求可以接受演员的返回值", httpMethod = "Get")
//     public void AkkaAsk() {
// ​
//         ActorSystem actorSystem = ActorSystem.create();
//         ActorRef actor = actorSystem.actorOf(Props.create(ActorNormal.class), "actorNormal");
// ​
//         Timeout timeout = new Timeout(Duration.create(2, TimeUnit.SECONDS));
//         Future<Object> future = Patterns.ask(actor, "我是接收游戏返回值", timeout);
//         try {
//             Object obj = Await.result(future, timeout.duration());
//             String reply = obj.toString();
//             System.out.println("回复的消息: " + reply);//返回值获取不到
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
// ​
//     }
// ​
//     @GetMapping(value = "/Akka/AkkaAskStruct")
//     @ResponseBody
//     // @ApiOperation(value = "Akka使用Ask请求带构造函数的演员", notes = "带构造函数的演员", httpMethod = "Get")
//     public void AkkaAskStruct() {
// ​
// ​
//         ActorSystem actorSystem = ActorSystem.create();
//         ActorRef actor = actorSystem.actorOf(Props.create(ActorStruct.class,new User("1","kiba")), "actorNormal");
// ​
//         Timeout timeout = new Timeout(Duration.create(2, TimeUnit.SECONDS));
//         Future<Object> future = Patterns.ask(actor, "我是带构造函数的演员接收游戏返回值", timeout);
//         try {
//             Object obj = Await.result(future, timeout.duration());
//             String reply = obj.toString();
//             System.out.println("回复的消息: " + reply);//返回值获取不到
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }