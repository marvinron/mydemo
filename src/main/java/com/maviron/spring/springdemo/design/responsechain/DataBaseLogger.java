package com.maviron.spring.springdemo.design.responsechain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DataBaseLogger.java
 * @Description
 * @createTime 2023年05月10日 14:23:00
 */
public class DataBaseLogger extends Logger {

    public DataBaseLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DataBaseLogger " + message);
    }
}
