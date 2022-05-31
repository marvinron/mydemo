package com.maviron.spring.springdemo.demo.abstractdemo;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstractProvider.java
 * @Description TODO
 * @createTime 2021年11月23日 14:05:00
 */
public abstract class AbstractProvider {
    protected <T> void executeCommand(String key,Command<T> command,T defaultValue){
        command.execute();
    }
}
