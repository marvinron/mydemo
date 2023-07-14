package com.maviron.spring.springdemo.actor.akka.akkademo;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TaskManagerRequest.java
 * @Description TODO
 * @createTime 2023年07月14日 11:54:00
 */
public class TaskManagerRequest {
    private final String type;
    private final long ts;
    public TaskManagerRequest(String type, long ts) {
        this.type = type;
        this.ts = ts;
    }

    public String getType() {
        return type;
    }

    public long getTs() {
        return ts;
    }
}
