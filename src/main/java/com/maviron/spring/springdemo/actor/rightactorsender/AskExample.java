package com.maviron.spring.springdemo.actor.rightactorsender;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;

import java.time.Duration;

public class AskExample {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("mySystem");
        ActorRef topActor = system.actorOf(Props.create(TopActor.class), "topActor");

        Timeout timeout = Timeout.create(Duration.ofSeconds(500));
        Future<Object> future = Patterns.ask(topActor, "start", timeout);


        // 等待结果
        Object result = Await.result(future, timeout.duration());
        System.out.println("Result: " + result);

        system.terminate();
    }
}

class TopActor extends AbstractActor {
    private ActorRef middleActor;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    // 创建中间 actor
                    middleActor = getContext().actorOf(Props.create(MiddleActor.class), "middleActor");
                    // 将 ask 的临时 actor 引用传递给下一层
                    middleActor.tell(msg, getSender());
                })
                .build();
    }
}

class MiddleActor extends AbstractActor {
    private ActorRef bottomActor;

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    // 创建底层 actor
                    bottomActor = getContext().actorOf(Props.create(BottomActor.class), "bottomActor");
                    // 将 ask 的临时 actor 引用继续传递给下一层
                    bottomActor.tell(msg, getSender());
                })
                .build();
    }
}

class BottomActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("start", msg -> {
                    // 在这里处理消息，并将结果返回给 ask 的临时 actor
                    getSender().tell("Result from BottomActor", getSelf());
                })
                .build();
    }
}

class EmptyActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(msg -> {
                    // 这里只是为了创建一个 actor 来接收 ask 的响应
                    System.out.println("Received ask response: " + msg);
                })
                .build();
    }
}
