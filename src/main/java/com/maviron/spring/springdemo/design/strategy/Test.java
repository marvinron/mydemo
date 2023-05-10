package com.maviron.spring.springdemo.design.strategy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 策略模式测试
 * @createTime 2023年05月10日 11:05:00
 */
public class Test {
    public static void main(String[] args) {
        CoolingStrategyContext context = new CoolingStrategyContext(new FanCoolingStrategy());
        context.coolingHandle();

        context = new CoolingStrategyContext(new AirConditionerCoolingStrategy());
        context.coolingHandle();

        context = new CoolingStrategyContext(new IceCoolingStrategy());
        context.coolingHandle();
    }
}
