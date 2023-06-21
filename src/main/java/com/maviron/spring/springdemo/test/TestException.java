package com.maviron.spring.springdemo.test;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestException.java
 * @Description TODO
 * @createTime 2023年05月23日 11:42:00
 */
public class TestException {
    public static void main(String[] args) {
        CompletableFuture future1 = CompletableFuture
                // 任务1
                .supplyAsync(
                        () -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task1";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                            return taskName;
                        });
        CompletableFuture future2 = CompletableFuture
                // 任务2
                .supplyAsync(
                        () -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task2";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                            throw new RuntimeException("任务2异常！");
                        });
        CompletableFuture future3 = CompletableFuture
                // 任务3
                .supplyAsync(
                        () -> {
                            Thread currentThread = Thread.currentThread();
                            String ThreadName = currentThread.getName();
                            String taskName = "task3";
                            System.out.println(ThreadName + "开始执行任务：" + taskName);
                            System.out.println("正在执行任务" + taskName);
                            System.out.println(taskName + "执行结束");
                            throw new RuntimeException("任务3异常！");
                        });
        CompletableFuture[] futures = new CompletableFuture[]{future1, future2, future3};
        CompletableFuture allCompletableFuture = CompletableFuture.allOf(futures);
        try {
            allCompletableFuture.join();
        } catch (Exception e) {
            for (CompletableFuture future : futures) {
                if (future.isCompletedExceptionally()) {
                    try {
                        future.join();
                    } catch (Throwable ct) {
                        System.out.println(ct.getMessage());
                    }
                }
            }
        }


        CompletableFuture<?> anyException = new CompletableFuture<>();
        for (CompletableFuture<?> completableFuture : futures) {
            completableFuture.exceptionally((t) -> {
                // 任何一个任务异常都会让anyException任务完成
                anyException.completeExceptionally(t);
                return null;
            });
        }
        // 要么allCompletableFuture全部成功，要么一个出现异常就结束任务
        CompletableFuture.anyOf(allCompletableFuture, anyException)
                .whenComplete((value, exception) -> {
                    if (Objects.nonNull(exception)) {
                        System.out.println("产生异常，提前结束！"+ exception.getMessage());
                        //exception.printStackTrace();
                        return;
                    }
                    System.out.println("所有任务正常完成！");
                });

    }
}
