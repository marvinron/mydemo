package com.maviron.spring.springdemo.design.adapter;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ConcreteTarget.java
 * @Description 目标的具体的角色
 * @createTime 2023年05月10日 15:58:00
 */
public class ConcreteTarget implements Target {
    @Override
    public void t1() {
        System.out.println("目标角色 t1的方法 ");
    }

    @Override
    public void t2() {
        System.out.println("目标角色 t2的方法 ");
    }

    @Override
    public void t3() {
        System.out.println("目标角色 t3的方法 ");
    }
}
