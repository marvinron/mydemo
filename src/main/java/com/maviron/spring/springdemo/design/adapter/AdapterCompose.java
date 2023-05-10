package com.maviron.spring.springdemo.design.adapter;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AdapterCompose.java
 * @Description
 * @createTime 2023年05月10日 16:06:00
 */
public class AdapterCompose implements Target {
    private Adaptee adaptee;

    public AdapterCompose(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void t1() {
        adaptee.a1();
    }

    @Override
    public void t2() {
        adaptee.a2();

    }

    @Override
    public void t3() {
        adaptee.a3();
    }
}
