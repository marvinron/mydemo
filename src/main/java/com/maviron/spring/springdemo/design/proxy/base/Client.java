package com.maviron.spring.springdemo.design.proxy.base;

// 测试类
public class Client {  

    public static void main(String[] args) {  
        // 真实对象  
        Subject realSubject = new RealSubject();  
        // 代理对象  
        Subject proxy = new Proxy(realSubject);  
        proxy.request();  
    }  
  
}