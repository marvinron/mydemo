package com.maviron.spring.springdemo.normalarithmetic.optimalizingresponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ResponseTime.java
 * @Description 最优响应算法
 * @createTime 2022年08月15日 15:54:00
 */
public class ResponseTime {
    // 创建一个定长的线程池，用于去执行ping任务
    static ExecutorService pingServerPool =
            Executors.newFixedThreadPool(Servers.SERVERS.size());

    public static Server getServer() throws Exception {
        //创建一个CompletableFuture用于拼接任务
        CompletableFuture cfAnyOf;
        //创建一个接收结果返回的server节点对象
        final Server resultServer = new Server();
        // 根据集群节点数量初始化一个异步任务数组
        CompletableFuture[] cfs = new CompletableFuture[Servers.SERVERS.size()];
        // 遍历整个服务器列表，为每个节点创建一个ping任务
        for (Server server : Servers.SERVERS) {
            // 获取当前节点在集群列表中的下标
            int index = Servers.SERVERS.indexOf(server);
            // 为每个节点创建一个ping任务，并交给pingServerPool线程池执行
            CompletableFuture<String> cf =
                    CompletableFuture.supplyAsync(server::ping,pingServerPool);
            // 将创建好的异步任务加入数组中
            cfs[index] = cf;
        }
        // 将创建好的多个Ping任务组合成一个聚合任务并执行
        cfAnyOf = CompletableFuture.anyOf(cfs);
        // 监听执行完成后的回调，谁先执行完成则返回谁
        cfAnyOf.thenAccept(resultIP -> {
            System.out.println("最先响应检测请求的节点为：" + resultIP);
            resultServer.setIP((String) resultIP);
        });
        Object o = cfAnyOf.get();
        System.out.println(o);
        return (Server)o;
    }
}
