package com.maviron.spring.springdemo.demo;

import io.netty.util.HashedWheelTimer;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestWheel.java
 * @Description TODO
 * @createTime 2023年12月27日 12:12:00
 */
@Slf4j
public class TestWheel {

    public static void main(String[] args) {
        HashedWheelTimer timer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS, 8);
        timer.start();

        log.info("提交延迟任务");
        timer.newTimeout(timeout -> log.info("执行延迟任务"), 5, TimeUnit.SECONDS);
        //long l = timer.pendingTimeouts();
        //System.out.println(l);
        //timer.stop();
    }
}
