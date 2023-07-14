package com.maviron.spring.springdemo.actor.akka.akkademo;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName InitRequest.java
 * @Description TODO
 * @createTime 2023年07月14日 11:52:00
 */
public class InitRequest {
    private final int taskManagerNumber;

    public InitRequest(int taskManagerNumber) {
        this.taskManagerNumber = taskManagerNumber;
    }

    public int getTaskManagerNumber() {
        return taskManagerNumber;
    }
}
