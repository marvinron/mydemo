package com.maviron.spring.springdemo.design.responsechain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ConsoleLogger.java
 * @Description ConsoleLogger策略
 * @createTime 2023年05月10日 14:20:00
 */
public class ConsoleLogger extends Logger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("ConsoleLogger " + message);
    }
}
