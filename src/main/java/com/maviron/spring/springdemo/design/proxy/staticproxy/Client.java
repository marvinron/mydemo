package com.maviron.spring.springdemo.design.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {  
        //IGamePlayer gamePlayer = new GamePlayer("豆豆");
        //System.out.println("开始时间:" + System.currentTimeMillis());
        //gamePlayer.login("username1", "password1");
        //gamePlayer.killBoss();
        //gamePlayer.upgrade();
        //System.out.println("结束时间:" + System.currentTimeMillis());

        IGamePlayer gamePlayer = new GamePlayer("豆豆");
        // 定义一个游戏代练
        IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
        System.out.println("开始时间:" + System.currentTimeMillis());
        proxy.login("username1", "password1");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间:" + System.currentTimeMillis());
    }  
}