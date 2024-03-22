package com.maviron.spring.springdemo.actor.akka.akkanew;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class MultiLayerCallWithAskExample {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");

        // 创建第一个actor
        ActorRef actor1 = system.actorOf(Props.create(Actor1.class), "actor1");

        // 使用ask操作向第一个actor发送消息，并等待返回结果
        Timeout timeout = Timeout.apply(5, TimeUnit.SECONDS);
        Future<Object> future = Patterns.ask(actor1, "Start", timeout);
        future.onComplete(response -> {
            if (response.isSuccess()) {
                System.out.println("Final response: " + response.get());
            } else {
                System.out.println("Failed to receive final response: " + response.failed().get());
            }
            system.terminate();
            return response;
        }, system.dispatcher());
    }

    static class Actor1 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, message -> {
                        System.out.println("Actor1 received: " + message);

                        // 创建第二个actor
                        ActorRef actor2 = getContext().actorOf(Props.create(Actor2.class));

                        // 使用ask操作向第二个actor发送消息，并等待返回结果
                        Future<Object> future = Patterns.ask(actor2, "Hello from Actor1", 5000);
                        future.onComplete(response -> {
                            if (response.isSuccess()) {
                                getSender().tell(response.get(), getSelf());
                            } else {
                                getSender().tell("Failed to receive response from Actor2", getSelf());
                            }
                            return response;
                        }, getContext().getSystem().dispatcher());
                    })
                    .build();
        }
    }

    static class Actor2 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, message -> {
                        System.out.println("Actor2 received: " + message);

                        // 创建第三个actor
                        ActorRef actor3 = getContext().actorOf(Props.create(Actor3.class));

                        // 向第三个actor发送消息
                        actor3.tell("Hello from Actor2", getSelf());
                    })
                    .build();
        }
    }

    static class Actor3 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, message -> {
                        System.out.println("Actor3 received: " + message);
                        getSender().tell("Response from Actor3", getSelf());
                    })
                    .build();
        }
    }
}
