package com.maviron.spring.springdemo.actor.test;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.maviron.spring.springdemo.actor.resultcollector.Request;
import com.maviron.spring.springdemo.until.Result;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import java.util.concurrent.TimeUnit;

public class ResultCollector extends UntypedAbstractActor {
    private Object result;

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Result) {
            result = message;
            getContext().stop(getSelf()); // 收到结果后停止 actor
        }
    }

    public Object getResult() {
        return result;
    }
}

class RequestWithCollectorActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Request) {
            ActorRef collector = getContext().actorOf(Props.create(ResultCollector.class));
            getSender().tell(new RequestWithCollector(collector), getSelf());
        } else if (message instanceof RequestWithCollector) {
            RequestWithCollector req = (RequestWithCollector) message;
            // 这里假设 actor2 已经被创建并已知
            ActorRef actor2 = getContext().actorOf(Props.create(Actor2.class));
            actor2.tell(req, getSelf());
        }
    }
}

class Actor2 extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof RequestWithCollector) {
            RequestWithCollector req = (RequestWithCollector) message;
            // 假设 actor3 已经被创建并已知
            ActorRef actor3 = getContext().actorOf(Props.create(Actor3.class));
            actor3.tell(req, getSelf());
        }
    }
}

class Actor3 extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof RequestWithCollector) {
            RequestWithCollector req = (RequestWithCollector) message;
            // 处理请求并发送结果
            Result result = new Result(); // 假设我们创建了一个结果对象
            req.getCollector().tell(result, getSelf());
        }
    }
}

class RequestWithCollector {
    private final ActorRef collector;

    public RequestWithCollector(ActorRef collector) {
        this.collector = collector;
    }

    public ActorRef getCollector() {
        return collector;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        ActorSystem system = ActorSystem.create("mySystem");
        
        // 创建必要的 actors
        ActorRef actor1 = system.actorOf(Props.create(RequestWithCollectorActor.class), "actor1");
        ActorRef actor2 = system.actorOf(Props.create(Actor2.class), "actor2");
        ActorRef actor3 = system.actorOf(Props.create(Actor3.class), "actor3");

        Timeout timeout = new Timeout(5, TimeUnit.DAYS);

        // 发起 ask 请求
        Future<Object> future = Patterns.ask(actor1, new RequestWithCollectorActor(), timeout);

        // 等待结果
        Object result = Await.result(future, Duration.create(5, TimeUnit.DAYS));

        // 输出结果
        System.out.println("Result: " + result);

        // 关闭系统
        system.terminate();
    }
}
