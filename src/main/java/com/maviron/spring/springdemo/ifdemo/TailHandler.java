package com.maviron.spring.springdemo.ifdemo;

// 尾节点，直接抛出异常，因为到了尾节点说明当前 code 没有处理
public class TailHandler extends ActionHandler{

    @Override
    public void doHandler(String actionCode) {
        System.out.println("当前 code[" + actionCode + "] 没有具体的 Handler 处理");
    }
}