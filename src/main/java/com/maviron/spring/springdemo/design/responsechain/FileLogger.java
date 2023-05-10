package com.maviron.spring.springdemo.design.responsechain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName FileLogger.java
 * @Description TODO
 * @createTime 2023年05月10日 14:22:00
 */
public class FileLogger extends Logger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("FileLogger " + message);
    }
}
