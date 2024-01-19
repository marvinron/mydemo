package com.maviron.spring.springdemo.design.proxy.base;

// 真实主题角色
public class RealSubject implements Subject{  
  
    @Override  
    public void request() {  
        System.out.println("do sth.");  
    }  
  
}