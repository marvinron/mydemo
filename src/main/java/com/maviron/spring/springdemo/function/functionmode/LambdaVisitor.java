package com.maviron.spring.springdemo.function.functionmode;

import java.util.function.Function;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName LambdaVisitor.java
 * @Description 使用lambda表达式的函数模式
 * @createTime 2022年07月15日 11:16:00
 */
public class LambdaVisitor<A> implements Function<Object,A> {
    @Override
    public A apply(Object o) {
        return null;
    }

    @Override
    public <V> Function<V, A> compose(Function<? super V, ?> before) {
        return null;
    }

    @Override
    public <V> Function<Object, V> andThen(Function<? super A, ? extends V> after) {
        return null;
    }
}
