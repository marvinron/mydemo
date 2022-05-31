package com.maviron.spring.springdemo.design.observer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Observer.java
 * @Description 观察者
 * @createTime 2022年04月25日 10:51:00
 */
public interface Observer {
    void notify(String orderNo);
}
