package com.maviron.spring.springdemo.importdesc;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ServiceA.java
 * @Description TODO
 * @createTime 2022年08月11日 10:08:00
 */
public class ServiceA implements ServiceInterface {
    @Override
    public void test() {
        System.out.println("service A");
    }
}
