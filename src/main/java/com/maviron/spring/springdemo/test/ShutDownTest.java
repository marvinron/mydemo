package com.maviron.spring.springdemo.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ShutDownTest.java
 * @Description TODO
 * @createTime 2023年11月24日 11:01:00
 */
public class ShutDownTest {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> close()));
    }

    private static void close() {
        try {
            System.out.println("clean");
            executorService.shutdown();
            System.out.println(executorService.awaitTermination(10000, TimeUnit.SECONDS));
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final int index = i;
            try {
                executorService.schedule(() -> System.out.println("yes" + index), 3, TimeUnit.SECONDS);
                System.out.println("add thread");
            } catch (Exception e) {
            }
            System.exit(0);
        }

    }

}
