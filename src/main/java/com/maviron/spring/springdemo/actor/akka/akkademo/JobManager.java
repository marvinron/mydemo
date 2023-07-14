package com.maviron.spring.springdemo.actor.akka.akkademo;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName JobManager.java
 * @Description TODO
 * @createTime 2023年07月14日 11:25:00
 */
public class JobManager extends AbstractActor {

    private ConcurrentHashMap<ActorRef, Long> heartbeat;

    private volatile boolean isRunning = false;


    @Override
    public void preStart() throws Exception {
        heartbeat = new ConcurrentHashMap<>();
        new Thread(() -> {
            while (true) {
                if (isRunning) checkHeartbeat();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    // no-op
                }
            }
        }).start();
    }

    private void checkHeartbeat() {
        long currentTimeMillis = System.currentTimeMillis();
        Enumeration<ActorRef> keys = heartbeat.keys();
        while (keys.hasMoreElements()) {
            ActorRef actorRef = keys.nextElement();
            if (currentTimeMillis - 5000 > heartbeat.get(actorRef)) {
                System.out.println(actorRef + "已经挂掉了，尝试关闭它");
                getContext().stop(actorRef);
            }
        }
    }


    // 提供 Props 的静态方法，同时还可以传入一些参数，作为实例化 JobManager 的参数
    static Props props() {
        return Props.create(JobManager.class, JobManager::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(InitRequest.class, message -> {
            System.out.println("开始初始化...");
            for (int i = 0; i < message.getTaskManagerNumber(); i++) {
                getContext().actorOf(TaskManager.props(), "taskManager-" + i);
            }
        }).match(TaskManagerRequest.class, message -> {
            if ("init".equals(message.getType())) {
                heartbeat.put(sender(), message.getTs());
                System.out.println("收到 " + sender() + " init 信息");
                if (!isRunning) {
                    isRunning = true;
                }
            } else if ("heartbeat".equals(message.getType())) {
                heartbeat.put(sender(), message.getTs());
                System.out.println("收到 " + sender() + " heartbeat 信息");
            }
        }).matchEquals("stop", message -> {
            isRunning = false;
            getContext().stop(self());
        }).build();
    }
}
