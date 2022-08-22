package com.maviron.spring.springdemo.importdesc;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ServiceB.java
 * @Description TODO
 * @createTime 2022年08月11日 10:09:00
 */
public class ServiceB implements ServiceInterface{
    @Override
    public void test() {
        System.out.println("ServiceB");
    }
}
