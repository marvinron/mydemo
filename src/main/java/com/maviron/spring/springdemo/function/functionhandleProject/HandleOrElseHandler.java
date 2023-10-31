package com.maviron.spring.springdemo.function.functionhandleProject;

import java.util.function.Function;

@FunctionalInterface
public interface HandleOrElseHandler<T,R> {

    R presentOrElseHandle(Function<T, R> presentAction, Function<T, R> elseAction);
}