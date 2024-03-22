package com.maviron.spring.springdemo.actor.akka.akkanew;

import akka.actor.*;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");

        ActorRef actor1 = system.actorOf(Props.create(Actor1.class));
        ActorRef actor2 = system.actorOf(Props.create(Actor2.class));
        ActorRef actor3 = system.actorOf(Props.create(Actor3.class));

        Timeout timeout = Timeout.apply(5, TimeUnit.SECONDS);
        CompletableFuture<Object> future = Patterns.ask(actor1, "start", java.time.Duration.ofMillis(1000000)).toCompletableFuture();
        future.thenAccept(response -> {
            System.out.println("Final response: " + response);
            system.terminate();
        });
    }

    public static class Actor1 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Actor1 received request: " + msg);
                        ActorRef actor2 = getContext().actorOf(Props.create(Actor2.class));
                        actor2.tell("request to Actor2", self());
                        // sender().tell("request to Actor2", self());
                    })
                    .build();
        }
    }

    public static class Actor2 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Actor2 received request: " + msg);
                        ActorRef actor3 = getContext().actorOf(Props.create(Actor3.class));
                        actor3.tell("request to Actor3", self());
                    })
                    .build();
        }
    }

    public static class Actor3 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Actor3 received request: " + msg);
                        getSender().tell("final response", getSender());
                    })
                    .build();
        }
    }
}
