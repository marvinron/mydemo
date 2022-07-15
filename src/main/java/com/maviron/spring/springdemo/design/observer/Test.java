package com.maviron.spring.springdemo.design.observer;

import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 测试观察者模式
 * @createTime 2022年04月25日 11:02:00
 */
public class Test {
    @org.junit.Test
    public void test(){
        Subject subject = new SubjectImpl();
        subject.registerObserver(new OrderObserverImpl());
        subject.registerObserver(new StockOberverImpl());
        subject.notifyAllObserver("12321656");

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{

        }};
        String s = list.get(RandomUtil.randomInt(list.size()));
        System.out.println(s);
    }
}
