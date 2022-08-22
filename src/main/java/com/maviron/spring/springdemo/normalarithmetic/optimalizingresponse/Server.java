package com.maviron.spring.springdemo.normalarithmetic.optimalizingresponse;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Server.java
 * @Description TODO
 * @createTime 2022年08月15日 15:49:00
 */
public class Server {
    private String IP;
    public Server(){}
    public Server(String IP) {
        this.IP = IP;
    }
    public String getIP() {
        return IP;
    }
    public void setIP(String IP){
        this.IP = IP;
    }

    public String ping(){
        // 生成一个1000~3000之间的随机数
        int random = ThreadLocalRandom.current().nextInt(1000, 3000);
        try {
            // 随机休眠一段时间，模拟不同的响应速度
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.IP;
    }

}
