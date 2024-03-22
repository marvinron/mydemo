package com.maviron.spring.springdemo.actor.akka.akkanewtest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.maviron.spring.springdemo.actor.akka.akkatest.RequestMessage;
import com.maviron.spring.springdemo.actor.akka.akkatest.ResponseMessage;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // 创建Actor系统
        ActorSystem system = ActorSystem.create("MySystem");

        // 创建Actor实例
        ActorRef actor1 = system.actorOf(Props.create(Actor1.class), "actor1");

        // 发送请求消息到actor1，并等待响应
        Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        Future<Object> future = Patterns.ask(actor1, new RequestMessage(), timeout);

        try {
            // 等待并获取响应消息
            ResponseMessage response = (ResponseMessage) Await.result(future, timeout.duration());
            // 处理响应消息
            System.out.println("Received response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭Actor系统
            system.terminate();
        }
    }
}

// Actor1类
class Actor1 extends AbstractActor {
    private ActorRef actor2;

    @Override
    public void preStart() {
        // 创建Actor2实例
        actor2 = getContext().actorOf(Props.create(Actor2.class), "actor2");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessage.class, this::handleRequest)
                .build();
    }

    private void handleRequest(RequestMessage message) {
        // 处理请求消息
        // 将消息发送给Actor2，并等待响应
        Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        Future<Object> future = Patterns.ask(actor2, message, timeout);
        
        try {
            // 等待并获取响应消息
            ResponseMessage response = (ResponseMessage) Await.result(future, timeout.duration());
            // 将响应消息发送给发送者
            getSender().tell(response, getSelf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Actor2类
class Actor2 extends AbstractActor {
    private ActorRef finalActor;

    @Override
    public void preStart() {
        // 创建FinalActor实例
        finalActor = getContext().actorOf(Props.create(FinalActor.class), "finalActor");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessage.class, this::handleIntermediateRequest)
                .build();
    }

    private void handleIntermediateRequest(RequestMessage message) {
        // 处理中间消息
        // 将消息发送给FinalActor，并等待响应
        Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
        Future<Object> future = Patterns.ask(finalActor, message, timeout);
        
        try {
            // 等待并获取响应消息
            ResponseMessage response = (ResponseMessage) Await.result(future, timeout.duration());
            // 将响应消息发送给发送者
            getSender().tell(response, getSelf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// FinalActor类
class FinalActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessage.class, this::handleFinalRequest)
                .build();
    }

    private void handleFinalRequest(RequestMessage message) {
        // 处理最终消息
        // 生成最终响应消息
        ResponseMessage response = new ResponseMessage();
        // 发送响应消息给发送者
        getSender().tell(response, getSelf());
    }
}
