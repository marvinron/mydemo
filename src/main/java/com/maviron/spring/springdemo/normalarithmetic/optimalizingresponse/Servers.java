package com.maviron.spring.springdemo.normalarithmetic.optimalizingresponse;


import java.util.Arrays;
import java.util.List;

/**
 * 最优响应服务Ip
 */
public class Servers {
    // 模拟的集群节点信息，活跃数最开始默认为0
    public static List<Server> SERVERS = Arrays.asList(
            new Server("44.120.110.001:8080"),
            new Server("44.120.110.002:8081"),
            new Server("44.120.110.003:8082")
    );

}