package com.maviron.spring.springdemo.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThreadDemo.java
 * @Description 使用线程池处理事务
 * @createTime 2022年08月26日 09:23:00
 */
public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService =
                Executors.newFixedThreadPool(4);
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Future<String>> futures = new ArrayList<>();
        for (Integer i : list) {
            Future<String> future = executorService.submit(() -> {
                //try {
                //    Thread.sleep(1000L);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                return "处理结果：" + i;
            });
            futures.add(future);
        }
        for (Future<String> future : futures) {
            String result = future.get();
            System.out.println(result);
        }
        executorService.shutdown();

    }
}
