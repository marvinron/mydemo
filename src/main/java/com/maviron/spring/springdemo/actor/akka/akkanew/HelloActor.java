package com.maviron.spring.springdemo.actor.akka.akkanew;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnComplete;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HelloActor.java
 * @Description actor的ask方法
 * @createTime 2024年03月18日 10:06:00
 */
public class HelloActor extends AbstractActor {

    public static void main(String[] args) {
        ActorSystem mySystem = ActorSystem.create("mySystem");
        ActorRef helloActor = mySystem.actorOf(Props.create(HelloActor.class), "helloActor");
        Timeout timeout = new Timeout(Duration.create(2,"seconds"));
        // helloActor.tell("are you ready?", ActorRef.noSender());
        Future<Object> future = Patterns.ask(helloActor, "are you ready?", timeout);
        future.onComplete(new OnComplete<Object>() {
            @Override
            public void onComplete(Throwable failure, Object success) throws Throwable {
                if(failure != null){
                    System.out.println("some thing is wrong "+failure);
                }else{
                    System.out.println(" success :"+success);
                }
            }
        },mySystem.getDispatcher());

    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("hello",message -> {
            System.out.println(message);
        }).build();
    }
}
