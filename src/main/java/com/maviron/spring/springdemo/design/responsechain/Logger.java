package com.maviron.spring.springdemo.design.responsechain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Logger.java
 * @Description 抽象日志记录器
 * @createTime 2023年05月10日 14:15:00
 */
public abstract class Logger {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARNING = 3;
    public static final int ERROR = 4;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);

}
