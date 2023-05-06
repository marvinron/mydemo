package com.maviron.spring.springdemo.piplinedesign.piplineflow;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SecondValue.java
 * @Description secondValue
 * @createTime 2023年03月03日 14:06:00
 */
public class SecondValue<T> implements Value<T> {

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
        System.out.println("second value invoke "+t);
        getNext().invoke(t);
    }
}
