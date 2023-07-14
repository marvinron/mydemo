package com.maviron.spring.springdemo.actor.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ApplicationMaster.java
 * @Description TODO
 * @createTime 2023年07月14日 11:45:00
 */
public class ApplicationMaster {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("demo");
        ActorRef jobManager = system.actorOf(JobManager.props(), "jobManager");
        System.out.println(jobManager);
        // 发送消息
        jobManager.tell("init",ActorRef.noSender());
    }
}
