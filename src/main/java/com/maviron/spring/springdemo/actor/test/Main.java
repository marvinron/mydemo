package com.maviron.spring.springdemo.actor.test;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;

import java.time.Duration;

class MainTest {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("mySystem");
        ActorRef outerActor = system.actorOf(Props.create(OuterActor.class), "outerActor");
        
        Timeout timeout = Timeout.create(Duration.ofSeconds(500));
        Future<Object> future = Patterns.ask(outerActor, "start", timeout);
        Object result = Await.result(future, timeout.duration());
        System.out.println("Result: " + result);
        
        system.terminate();
    }
}

class OuterActor extends AbstractActor {
    private ActorRef middleActor;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    middleActor = getContext().actorOf(Props.create(MiddleActor.class), "middleActor");
                    middleActor.tell("start", getSelf());
                })
                .match(Object.class, msg -> {
                    // 接收来自内部actor的消息，并最终返回给ask
                    getSender().tell(msg, getSelf());
                })
                .build();
    }
}

class MiddleActor extends AbstractActor {
    private ActorRef innerActor;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    innerActor = getContext().actorOf(Props.create(InnerActor.class), "innerActor");
                    innerActor.tell("Hello from MiddleActor!", getSelf());
                })
                .match(Object.class, msg -> {
                    // 接收来自内部actor的消息，并将其传递给外部actor
                    getContext().parent().tell(msg, getSelf());
                })
                .build();
    }
}

class InnerActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("Hello from MiddleActor!", msg -> {
                    // 发送消息给父actor
                    getContext().parent().tell("Hello from InnerActor!", getSelf());
                })
                .build();
    }
}
