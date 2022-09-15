package com.maviron.spring.springdemo.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThreadDemo4.java
 * @Description TODO
 * @createTime 2022年08月26日 10:15:00
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        // 1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        CompletableFuture[] completableFutures = list.stream().map(key ->
                CompletableFuture.runAsync(() -> {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("结果：" + key);
                }, executorService)).toArray(CompletableFuture[]::new);
        CompletableFuture.anyOf(completableFutures).join();
        executorService.shutdown();
    }
}
