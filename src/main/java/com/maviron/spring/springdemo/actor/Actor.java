package com.maviron.spring.springdemo.actor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * java 实现actor模型
 *
 * @author houlei
 * @version 1.0.0
 * @ClassName Actor.java
 * @Description TODO
 * @createTime 2023年07月13日 14:28:00
 */
public abstract class Actor {
    private Node node;
    private String name;
    private final BlockingQueue<Message> mailbox = new LinkedBlockingQueue<>();
    private Thread actorThread;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start() {
        actorThread = new Thread(() -> {
            ActorSystem.setThreadLocalActor(this);
            for (; ; ) {
                try {
                    Message message = mailbox.take();
                    System.out.println(message.toString());  // 日志打印
                    handleMessage(message);
                } catch (Exception e) {

                }
            }
        });
        actorThread.start();
    }

    public void act(Message message) {
        mailbox.offer(message);
    }

    protected abstract void handleMessage(Message message);
}
