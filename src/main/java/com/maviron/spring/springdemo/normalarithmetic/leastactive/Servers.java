package com.maviron.spring.springdemo.normalarithmetic.leastactive;

import java.util.Arrays;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Servers.java
 * @Description 集群类：用于模拟集群节点列表
 * @createTime 2022年08月15日 15:22:00
 */
public class Servers {

    // 模拟的集群节点信息，活跃数最开始默认为0
    public static List<Server> SERVERS = Arrays.asList(
            new Server("44.120.110.001:8080",0),
            new Server("44.120.110.002:8081",0),
            new Server("44.120.110.003:8082",0)
    );
    /**
     * 活跃度衰减器
     */
    public static void attenuator() {
        new Thread(()->{
            // 遍历集群中的所有节点
            for (Server server : SERVERS) {
                // 如果活跃度不为0
                if (server.getActive().get() != 0){
                    // 则自减一个活跃度
                    server.getActive().getAndDecrement();
                }
            }
            try {
                // 每隔 2 秒中衰减一次活跃度
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static String getServer(){
        // 初始化最小活跃数和最小活跃数的节点
        int leastActive = Integer.MAX_VALUE;
        Server leastServer = new Server();
        // 遍历集群中的所有节点
        for (Server server : SERVERS) {
            // 找出活跃数最小的节点
            if (leastActive > server.getActive().get()){
                leastActive = server.getActive().get();
                leastServer = server;
            }
        }

        // 返回活跃数最小的节点IP
        return leastServer.getIP();
    }

    public static void main(String[] args){
        Servers.attenuator();
        for (int i = 1; i <= 10; i++){
            System.out.println("第"+ i + "个请求：" + getServer());
        }
    }
}
