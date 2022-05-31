package com.maviron.spring.springdemo.function.functionhandle;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PresentOrElseHandler.java
 * @Description TODO
 * @createTime 2022年04月22日 15:02:00
 */
@FunctionalInterface
public interface PresentOrElseHandler<T extends Object,R extends Object> {

    R presentOrElseHandle(Function<T, R> action, Function<T, R> emptyAction);
}
