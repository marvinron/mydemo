package com.maviron.spring.springdemo.design.strategy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName FanCoolingStrategy.java
 * @Description TODO
 * @createTime 2023年05月10日 11:00:00
 */
public class FanCoolingStrategy implements CoolingStrategy {
    @Override
    public void handle() {
        System.out.println("使用风扇降温");
    }
}
