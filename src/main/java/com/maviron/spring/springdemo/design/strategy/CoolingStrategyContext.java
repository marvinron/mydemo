package com.maviron.spring.springdemo.design.strategy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CoolingStrategyContext.java
 * @Description 降温的上下文
 * @createTime 2023年05月10日 11:03:00
 */
public class CoolingStrategyContext {
    /**
     * 降温策略
     */
    private final CoolingStrategy strategy;

    public CoolingStrategyContext(CoolingStrategy strategy) {
        this.strategy = strategy;
    }

    public void coolingHandle() {
        strategy.handle();
    }
}
