package com.maviron.spring.springdemo.function.truefalsehandle;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThrowExceptionFunction.java
 * @Description 抛出异常的函数接口
 * @createTime 2022年04月15日 10:55:00
 */
@FunctionalInterface
public interface ThrowExceptionFunction {

    void throwMessage(String message);
}
