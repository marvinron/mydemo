package com.maviron.spring.springdemo.actor.actorsenderbackpressure;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.stream.Materializer;
import akka.stream.OverflowStrategy;
import akka.stream.javadsl.Source;
import akka.util.Timeout;

import java.time.Duration;

public class AskExample {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("mySystem");
        ActorRef topActor = system.actorOf(Props.create(TopActor.class), "topActor");

        Timeout timeout = Timeout.create(Duration.ofSeconds(500));
        Materializer materializer = Materializer.createMaterializer(system);
        // 创建一个带有缓冲的Source，使用了OverflowStrategy.backpressure策略
        Source<String, akka.NotUsed> source = Source.range(1, 100)
                .map(i -> "work" + i)
                .buffer(10, OverflowStrategy.backpressure());
        // 创建一个Sink，使用Patterns.ask向topActor发送消息并等待结果
        // 将Source和Sink连接起来，并运行流
        // source.runWith(sink, materializer);

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
