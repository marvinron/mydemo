package com.maviron.spring.springdemo.normalarithmetic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RoudRobin.java
 * @Description TODO
 * @createTime 2022年08月15日 11:39:00
 */
public class RoudRobin {

    // 模拟配置的集群节点
    public static List<String> SERVERS = Arrays.asList(
            "44.120.110.001:8080",
            "44.120.110.002:8081",
            "44.120.110.003:8082",
            "44.120.110.004:8083",
            "44.120.110.005:8084"
    );

    // 用于记录当前请求的序列号
    private static AtomicInteger requestIndex = new AtomicInteger(0);

    // 从集群节点中选取一个节点处理请求
    public static String getServer(){
        // 用请求序列号取余集群节点数量，求得本次处理请求的节点下标
        int index = requestIndex.get() % SERVERS.size();
        // 从服务器列表中获取具体的节点IP地址信息
        String server = SERVERS.get(index);
        // 自增一次请求序列号，方便下个请求计算
        requestIndex.incrementAndGet();
        // 返回获取到的服务器IP地址
        return server;
    }

    public static void main(String[] args) {
        // 使用for循环简单模拟10个客户端请求
        for (int i = 1; i <= 10; i++){
            System.out.println("第"+ i + "个请求：" + getServer());
        }
    }
}
