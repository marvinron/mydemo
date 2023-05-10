package com.maviron.spring.springdemo.design.iterator;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Iterator.java
 * @Description 迭代器接口
 * @createTime 2023年05月10日 11:12:00
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
