package com.maviron.spring.springdemo.design.proxy.staticproxy;

// 游戏代练
public class GamePlayerProxy implements IGamePlayer {  
  
    private IGamePlayer iGamePlayer;  

    public GamePlayerProxy(IGamePlayer iGamePlayer) {  
        this.iGamePlayer = iGamePlayer;  
    }  

    @Override  
    public void login(String username, String password) {  
        iGamePlayer.login(username, password);  
    }  

    @Override  
    public void killBoss() {  
        iGamePlayer.killBoss();  
    }  

    @Override  
    public void upgrade() {  
        iGamePlayer.upgrade();  
    }  
}