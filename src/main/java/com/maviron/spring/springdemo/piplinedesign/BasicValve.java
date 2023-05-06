package com.maviron.spring.springdemo.piplinedesign;


/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BasicValve.java
 * @Description 基础阀门
 * @createTime 2023年03月03日 12:02:00
 */
public class BasicValve<T> implements Value<T> {
    protected Value next;

    @Override
    public Value getNext() {
        return next;
    }

    @Override
    public void setNext(Value value) {
        next = value;
    }

    @Override
    public void invoke(T t) {
        System.out.println("Basic value 接收到处理了" + t);
    }
}
