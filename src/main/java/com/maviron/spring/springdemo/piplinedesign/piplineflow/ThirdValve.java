package com.maviron.spring.springdemo.piplinedesign.piplineflow;

public class ThirdValve<T> implements Value<T> {
    public Value next;

    public Value getNext() {
        return next;
    }

    public void setNext(Value v) {
        next = v;
    }

    public void invoke(T s) {
        System.out.println("执行ThirdValve阀门，并掉调用下一个阀门");
        //注意这行代码
        getNext().invoke(s);
    }
}