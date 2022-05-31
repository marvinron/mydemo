package com.maviron.spring.springdemo.demo.abstractdemo;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Command.java
 * @Description 执行类接口
 * @createTime 2021年11月23日 14:02:00
 */
public interface Command<T> {
    void execute();
}
