package com.maviron.spring.springdemo.function.nullornotnullhandle;

import java.util.function.Consumer;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PresentOrElseHandler.java
 * @Description 空值和非空值的处理
 * @createTime 2022年04月15日 12:31:00
 */
@FunctionalInterface
public interface PresentOrElseHandler<T extends Object> {
    /**
     * 值不为空时执行消费操作
     * 值为空时执行其他的操作
     * @param action 值不为空时 执行消费操作
     * @param emptyAction 值为空时执行其他操作
     */
    void presentOrElseHandle(Consumer<? super T> action, Runnable emptyAction);
}
