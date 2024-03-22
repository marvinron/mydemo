package com.maviron.spring.springdemo.actor.akka.akkatest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Actor1 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessage.class, this::handleRequest)
                .build();
    }

    private void handleRequest(RequestMessage message) {
        // 处理请求消息
        // 发送处理后的消息给Actor2
        getContext().actorOf(Props.create(Actor2.class)).tell(message, getSelf());
    }
}

 class Actor2 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RequestMessage.class, this::handleIntermediateRequest)
                .build();
    }

    private void handleIntermediateRequest(RequestMessage message) {
        // 处理中间消息
        // 发送处理后的消息给FinalActor
        getContext().actorOf(Props.create(FinalActor.class)).tell(message, getSelf());
    }
}

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
