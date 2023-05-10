package com.maviron.spring.springdemo.design.iterator;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Aggregate.java
 * @Description 聚合接口
 * @createTime 2023年05月10日 11:13:00
 */
public interface Aggregate<T> {
    Iterator<T> createIterator();
}
