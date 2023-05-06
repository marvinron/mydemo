package com.maviron.spring.springdemo.piplinedesign.piplineflow;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName Pipeline.java
 * @Description 管道接口
 * @createTime 2023年03月03日 11:58:00
 */
public interface Pipeline {
    Value getFirst();

    Value getBasic();

    void setBasic(Value v);

    void addValve(Value v);
}
