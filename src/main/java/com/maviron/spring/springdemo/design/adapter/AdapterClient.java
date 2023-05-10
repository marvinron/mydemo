package com.maviron.spring.springdemo.design.adapter;

public class AdapterClient {

    public static void main(String[] args) {
        // 原有的业务逻辑
        Target target = new ConcreteTarget();
        target.t1();

        // 基于继承 增加适配器业务逻辑
        Target target1 = new Adapter();
        target1.t1();

        // 基于组合 增加适配器业务逻辑
        Target target2 = new AdapterCompose(new Adaptee());
        target2.t1();
    }
}