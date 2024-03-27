package com.maviron.spring.springdemo.actor;

import akka.Done;
import akka.NotUsed;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.ThrottleMode;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.Timeout;
import com.maviron.spring.springdemo.actor.akka.akkatest.RequestMessage;
import com.maviron.spring.springdemo.actor.akka.akkatest.ResponseMessage;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // 创建Actor系统
        ActorSystem system = ActorSystem.create("MySystemNew");
        ActorRef actor1 = system.actorOf(Props.create(Actor1.class), "actor1new");
        // 创建Actor材料化器
        Materializer materializer = ActorMaterializer.create(system);

        // 创建一个Source来接收请求消息
        Source<RequestMessage, NotUsed> requestSource = createRequestSource();

        // 创建一个Sink用于处理响应消息
        Sink<ResponseMessage, CompletionStage<Done>> responseSink = createResponseSink();

        // 将请求源与处理流程和背压控制连接起来
        requestSource
                .throttle(1, Duration.create(1, TimeUnit.DAYS), 10, ThrottleMode.shaping())
                .mapAsync(1, request -> {
                    CompletableFuture<ResponseMessage> future = new CompletableFuture<>();

                    Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
                    Future<Object> actorResponse = Patterns.ask(actor1, request, timeout);
                    actorResponse.onComplete(response -> {
                        if (response.isSuccess()) {
                            future.complete((ResponseMessage) response.get());
                        } else {
                            future.completeExceptionally(response.failed().get());
                        }
                        system.terminate();
                        return future;
                    }, system.dispatcher());
                    return future;
                })
                .to(responseSink)
                .run(materializer);
    }

    // 创建一个用于接收请求消息的Source
    private static Source<RequestMessage, NotUsed> createRequestSource() {
        // 在实际应用中，你可能需要根据具体情况来创建请求源
        // 这里只是一个示例，你可以根据需要进行替换
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setMessage("213123");
        return Source.single(requestMessage);
    }

    // 创建一个用于处理响应消息的Sink
    private static Sink<ResponseMessage, CompletionStage<Done>> createResponseSink() {
        // 在实际应用中，你可能需要根据具体情况来创建响应消息处理逻辑
        // 这里只是一个示例，你可以根据需要进行替换
        return Sink.foreach((ResponseMessage response) -> {
            // 处理响应消息的逻辑
            System.out.println("Received response: " + response);
        });
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
            response.setNessage("response from FinalActor ");
            // 发送响应消息给发送者
            getSender().tell(response, getSelf());
        }
}
