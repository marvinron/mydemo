package com.maviron.spring.springdemo.actor.akka;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName JobManager.java
 * @Description TODO
 * @createTime 2023年07月14日 11:25:00
 */
public class JobManager extends AbstractActor {
    // 提供 Props 的静态方法，同时还可以传入一些参数，作为实例化 JobManager 的参数
    static Props props() {
        return Props.create(JobManager.class, JobManager::new);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("init",message-> System.out.printf("hello %s,I'm %s%n", sender().path().name(), self().path().name())).build();
    }
}
