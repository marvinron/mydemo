package com.maviron.spring.springdemo.design.proxy.base;

// Proxy代理主题角色
public class Proxy implements Subject {  
  
    private Subject subject;  

    public Proxy(Subject subject) {  
        this.subject = subject;  
    }  

    @Override  
    public void request() {  
        before();  
        subject.request();  
        after();  
    }  

    private void before() {  
        System.out.println("预处理...");  
    }  

    private void after() {  
        System.out.println("善后...");  
    }  
  
}