package com.maviron.spring.springdemo.design.proxy.staticproxy;

// 具体的游戏玩家
public class GamePlayer implements IGamePlayer {  

    private String nickname;  

    public GamePlayer(String nickname) {  
        this.nickname = nickname;  
    }  

    @Override  
    public void login(String username, String password) {  
        System.out.println("登录名为" + username + "的用户" + nickname + "登录成功");  
    }  

    @Override  
    public void killBoss() {  
        System.out.println(nickname + "正在打boss...");  
    }  

    @Override  
    public void upgrade() {  
        System.out.println(nickname + "又升了一级");  
    }  
}