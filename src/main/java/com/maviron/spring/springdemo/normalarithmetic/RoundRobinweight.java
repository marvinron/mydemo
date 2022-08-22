package com.maviron.spring.springdemo.normalarithmetic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RoundRobinweight.java
 * @Description TODO
 * @createTime 2022年08月15日 11:53:00
 */
public class RoundRobinweight {
    private static AtomicInteger requestCount = new AtomicInteger(0);
    // 在之前是Servers类中再加入一个权重服务列表
    public static Map<String, Integer> WEIGHT_SERVERS = new LinkedHashMap<>();
    static {
        // 配置集群的所有节点信息及权重值
        WEIGHT_SERVERS.put("44.120.110.001:8080",17);
        WEIGHT_SERVERS.put("44.120.110.002:8081",11);
        WEIGHT_SERVERS.put("44.120.110.003:8082",30);
    }
    public static String getServer(){
        int weightTotal = 0;
        for (Integer weight : WEIGHT_SERVERS.values()) {
            weightTotal += weight;
        }

        String targetServer = "";
        int index = requestCount.get() % weightTotal;
        requestCount.incrementAndGet();

        for (String server : WEIGHT_SERVERS.keySet()) {
            Integer weight = WEIGHT_SERVERS.get(server);
            if (weight > index){
                targetServer = server;
                break;
            }
            index = index - weight;
        }
        return targetServer;
    }
}
