package com.maviron.spring.springdemo.thread;

import cn.hutool.core.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThreadDemo.java
 * @Description 使用线程池处理事务
 * @createTime 2022年08月26日 09:23:00
 */
public class ThreadDemo {
    private static final Logger logger = LoggerFactory.getLogger(ThreadDemo.class);

    public static void main(String[] args) throws Exception {
        //ExecutorService executorService =
        //        Executors.newFixedThreadPool(4);
        //List<Integer> list = Arrays.asList(1, 2, 3, 4);
        //List<Future<String>> futures = new ArrayList<>();
        //for (Integer i : list) {
        //    Future<String> future = executorService.submit(() -> {
        //        //try {
        //        //    Thread.sleep(1000L);
        //        //} catch (InterruptedException e) {
        //        //    e.printStackTrace();
        //        //}
        //        return "处理结果：" + i;
        //    });
        //    futures.add(future);
        //}
        //for (Future<String> future : futures) {
        //    String result = future.get();
        //    System.out.println(result);
        //}
        //executorService.shutdown();

        allOfGet();
    }

    /**
     * 异步，多任务。汇总返回值
     */
    public static void allOfGet() throws InterruptedException, ExecutionException{
        //该线程池仅用于示例，实际建议使用自定义的线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //线程安全的list，适合写多读少的场景
        //List<String> resultList = Collections.synchronizedList(new ArrayList<>(50));
        //CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(
        //        () -> runTask("result1", 1000), executorService)
        //        .whenComplete((result, throwable) -> {
        //            //任务完成时执行。用list存放任务的返回值
        //            if (result != null) {
        //                resultList.add(result);
        //            }
        //            //触发异常
        //            if (throwable != null) {
        //                logger.error("completableFuture1  error:{}", throwable);
        //            }
        //        });
        //
        //CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(
        //        () -> runTask("result2", 2000), executorService)
        //        .whenComplete((result, throwable) -> {
        //            if (result != null) {
        //                resultList.add(result);
        //            }
        //            if (throwable != null) {
        //                logger.error("completableFuture2  error:{}", throwable);
        //            }
        //
        //        });
        //
        //List<CompletableFuture<String>> futureList = new ArrayList<>();
        //futureList.add(completableFuture1);
        //futureList.add(completableFuture2);
        //
        //try {
        //    //多个任务
        //    CompletableFuture[] futureArray = futureList.toArray(new CompletableFuture[0]);
        //    //将多个任务，汇总成一个任务，总共耗时不超时2秒
        //    CompletableFuture.allOf(futureArray).get(2, TimeUnit.SECONDS);
        //} catch (Exception e) {
        //
        //}
        //List<String> list = new ArrayList<>(resultList);
        //list.forEach(System.out::println);

        List<String> results = Collections.synchronizedList(new ArrayList<String>());
        List<String> list2 = new ArrayList();
        list2.add("own1");
        list2.add("own2");
        List<CompletableFuture<String>> collects = list2.stream().map(str ->
                CompletableFuture.supplyAsync(() -> runTask(str, RandomUtil.randomInt(3000)), executorService).whenComplete((result, throwable) -> {
                    results.add(result);
                })
        ).collect(toList());
        //多个任务
        CompletableFuture[] futurecollects = collects.toArray(new CompletableFuture[0]);
        //将多个任务，汇总成一个任务，总共耗时不超时2秒
        try {
            CompletableFuture.allOf(futurecollects).get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        List<String> list3 = new ArrayList<>(results);
        list3.forEach(System.out::println);
        executorService.shutdown();

    }


    private static String runTask(String result, int millis) {
        try {
            //此处忽略实际的逻辑，用sleep代替
            //任务耗时。可以分别设置1000和3000，看未超时和超时的不同结果。
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
        return result;
    }


}
