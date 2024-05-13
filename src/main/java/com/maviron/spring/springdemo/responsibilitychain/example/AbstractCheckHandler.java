package com.maviron.spring.springdemo.responsibilitychain.example;

import com.maviron.spring.springdemo.until.Result;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstractCheckHandler.java
 * @Description 处理器的抽象类
 * @createTime 2024年04月12日 10:20:00
 */
@Component
public abstract class AbstractCheckHandler {
    /**
     * 当前处理器持有下一个处理器的引用
     */
    protected AbstractCheckHandler nextHandler;
    /**
     * 处理器的配置 可以通过配置中心动态修改配置 实现处理器的动态编排和顺序控制
     * 配置类中可以配置处理器的名称、下一处理器、以及处理器是否降级等属性
     */
    protected ProductCheckHandlerConfig config;

    /**
     * 处理器执行方法
     *
     * @param param
     * @return
     */
    public abstract Result handle(ProductVO param);

    /**
     * 链路传递
     *
     * @param param
     * @return
     */
    protected Result next(ProductVO param) {
        //下一个链路没有处理器了，直接返回
        if (Objects.isNull(nextHandler)) {
            return Result.success();
        }

        //执行下一个处理器
        return nextHandler.handle(param);
    }

    public AbstractCheckHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractCheckHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public ProductCheckHandlerConfig getConfig() {
        return config;
    }

    public void setConfig(ProductCheckHandlerConfig config) {
        this.config = config;
    }
}
