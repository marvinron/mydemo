package com.maviron.spring.springdemo.actor.akka.akkademo;

import akka.actor.AbstractActor;
import akka.actor.Props;

import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TaskManager.java
 * @Description
 * @createTime 2023年07月14日 11:26:00
 */
public class TaskManager extends AbstractActor {

    private volatile boolean isRunning = false;

    static Props props() {
        return Props.create(TaskManager.class, TaskManager::new);
    }

    @Override
    public void preStart() throws Exception {
        System.out.println("开始启动" + self());
        TimeUnit.SECONDS.sleep((int) (Math.random() * 5));
        getContext().actorSelection(self().path().parent()).tell(new TaskManagerRequest("init", System.currentTimeMillis()), self());
        System.out.println("启动完成" + self());
        isRunning = true;
        new Thread(() -> {
            while (true) {
                if (isRunning)
                    sendHeartbeat();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    // no-op
                }
            }
        }).start();

    }

    @Override
    public void postStop() throws Exception {
        System.out.println(self() + "关闭中...");
    }
    private void sendHeartbeat(){
        // 告诉 JobManager 启动好了，汇报当前时间
        System.out.println(self() + " 发送心跳数据");
        getContext().actorSelection(self().path().parent()).tell(new TaskManagerRequest("heartbeat", System.currentTimeMillis()), self());
    }

    @Override
    public Receive createReceive() {
        // 对所有的消息不做任何响应
        return receiveBuilder().matchEquals("fail", message -> isRunning = false).build();
    }
}
