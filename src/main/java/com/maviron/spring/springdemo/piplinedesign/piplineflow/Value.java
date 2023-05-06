package com.maviron.spring.springdemo.piplinedesign.piplineflow;


/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Value.java
 * @Description 阀门接口
 * @createTime 2023年03月03日 11:55:00
 */
public interface Value<T> {

    Value getNext();

    void setNext(Value value);

    void invoke(T t);
}
