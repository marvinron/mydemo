package com.maviron.spring.springdemo.design.responsechain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName LoggerDemo.java
 * @Description
 * @createTime 2023年05月10日 14:33:00
 */
public class LoggerDemo {
    private static Logger getChainOfLoggers() {
        Logger consoleLogger = new ConsoleLogger(Logger.DEBUG);
        Logger fileLogger = new FileLogger(Logger.INFO);
        Logger databaseLogger = new DataBaseLogger(Logger.ERROR);
        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(databaseLogger);
        return consoleLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(Logger.DEBUG, "This is a DEBUG level message.");
        //loggerChain.logMessage(Logger.INFO, "This is an INFO level message.");
        //loggerChain.logMessage(Logger.WARNING, "This is a WARNING level message.");
        //loggerChain.logMessage(Logger.ERROR, "This is an ERROR level message.");

    }
}
