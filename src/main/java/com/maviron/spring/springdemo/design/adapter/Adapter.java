package com.maviron.spring.springdemo.design.adapter;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Adapter.java
 * @Description 适配器
 * @createTime 2023年05月10日 16:05:00
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void t1() {
        super.a1();
    }

    @Override
    public void t2() {
        super.a2();
    }

    @Override
    public void t3() {
        super.a3();
    }
}
