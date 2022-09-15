package com.maviron.spring.springdemo.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThreadDemo2.java
 * @Description CompletableFuture使用示例
 * @createTime 2022年08月26日 09:42:00
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        // 1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (Integer i : list) {
            CompletableFuture.supplyAsync(() -> "结果" + i,executorService)
                    .whenCompleteAsync((result,exception)-> System.out.println(result));
        }
        executorService.shutdown();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
