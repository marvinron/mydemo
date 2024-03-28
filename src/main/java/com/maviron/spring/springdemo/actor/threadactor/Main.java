package com.maviron.spring.springdemo.actor.threadactor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("RequestChainDemo");

        ActorRef actor1 = system.actorOf(Props.create(Actor1.class), "actor1");
        ActorRef actor2 = system.actorOf(Props.create(Actor2.class), "actor2");
        ActorRef actor3 = system.actorOf(Props.create(Actor3.class), "actor3");

        actor1.tell("request", ActorRef.noSender());
    }

    static class Actor1 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Actor1 received request: " + msg);
                        getContext().actorSelection("../actor2").tell("message from Actor1", getSelf());
                    })
                    .build();
        }
    }

    static class Actor2 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Actor2 received message: " + msg);
                        getContext().actorSelection("../actor3").tell("message from Actor2", getSelf());
                    })
                    .build();
        }
    }

    static class Actor3 extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder()
                    .match(String.class, msg -> {
                        System.out.println("Actor3 received message: " + msg);
                        System.out.println("Response sent back to Actor1");
                        getSender().tell("response", getSelf());
                    })
                    .build();
        }
    }
}
