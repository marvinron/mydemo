package com.maviron.spring.springdemo.normalarithmetic.leastactive;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Server.java
 * @Description 节点类 用于封装集群中的每个节点
 * @createTime 2022年08月15日 15:17:00
 */
public class Server {
    private String IP;
    private AtomicInteger active;

    public Server() {
    }

    public Server(String IP, int active) {
        this.IP = IP;
        // 将外部传递的活跃数作为默认活跃数
        this.active = new AtomicInteger(active);
    }

    public String getIP() {
        // 每分发一个请求时自增一次活跃数
        active.incrementAndGet();
        return IP;
    }

    public AtomicInteger getActive() {
        return active;
    }


}
