package com.maviron.spring.springdemo.design.strategy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AirConditionerCoolingStrategy.java
 * @Description TODO
 * @createTime 2023年05月10日 11:01:00
 */
public class AirConditionerCoolingStrategy implements CoolingStrategy {
    @Override
    public void handle() {
        System.out.println("使用空调降温");
    }
}
