package com.maviron.spring.springdemo.design.observer;

import cn.hutool.core.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SubjectImpl.java
 * @Description 主题实现
 * @createTime 2022年04月25日 10:56:00
 */
public class SubjectImpl implements Subject {

    List<Observer> list = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void notifyAllObserver(String orderNo) {
        list.forEach(observer -> {
            observer.notify(orderNo);
        });
    }

}
