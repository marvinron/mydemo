package com.maviron.spring.springdemo.responsibilitychain.example;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ProductCheckHandlerConfig.java
 * @Description 处理器配置类
 * 表示每个处理器的动态配置类，可以通过“配置中心”动态修改该配置，
 * 实现处理器的“动态编排”和“顺序控制”。
 * 配置类中可以配置处理器的名称、下一个处理器、以及处理器是否降级等属性
 * @createTime 2024年04月12日 10:22:00
 */
public class ProductCheckHandlerConfig {
    /**
     * 处理器Bean名称
     */
    private String handler;
    /**
     * 下一个处理器
     */
    private ProductCheckHandlerConfig next;
    /**
     * 是否降级
     */
    private Boolean down = Boolean.FALSE;

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public ProductCheckHandlerConfig getNext() {
        return next;
    }

    public void setNext(ProductCheckHandlerConfig next) {
        this.next = next;
    }

    public Boolean getDown() {
        return down;
    }

    public void setDown(Boolean down) {
        this.down = down;
    }
}
