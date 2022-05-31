package com.maviron.spring.springdemo.function.truefalsehandle;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BranchHandle.java
 * @Description 函数型接口处理分支操作
 * @createTime 2022年04月15日 11:02:00
 */
@FunctionalInterface
public interface BranchHandle {
    /**
     * 分支操作
     *
     * @param trueHandle  当为true时进行的操作
     * @param falseHandle 当为false时进行的操作
     */
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);
}
