package com.maviron.spring.springdemo.demo.limit;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RateLimiterSimpleWindow.java
 * @Description 固定窗口算法
 * @createTime 2022年03月17日 12:15:00
 */
public class RateLimiterSimpleWindow {
    //阈值
    private static Integer QPS = 2;
    //时间窗口
    private static Integer TIME_WINDOWS = 1000;
    //计数器
    private static AtomicInteger REQ_COUNT = new AtomicInteger();
    //时间戳
    private static long START_TIME = System.currentTimeMillis();

    public synchronized static boolean tryAcquire() {
        if (System.currentTimeMillis() - START_TIME > TIME_WINDOWS) {
            REQ_COUNT.set(0);
            START_TIME = System.currentTimeMillis();
        }
        return REQ_COUNT.incrementAndGet() < QPS;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(400);
            LocalTime now = LocalTime.now();
            if (!tryAcquire()) {
                System.out.println(now + "被限流");
            } else {
                System.out.println(now + "做点什么");
            }
        }
    }

}
