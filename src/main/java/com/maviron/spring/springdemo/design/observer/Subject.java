package com.maviron.spring.springdemo.design.observer;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description 主题
 * @createTime 2022年04月25日 10:52:00
 */
public interface Subject {
    void registerObserver(Observer observer);
    void notifyAllObserver(String orderNo);

}
