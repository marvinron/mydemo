package com.maviron.spring.springdemo.design.visitor;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Visitor.java
 * @Description TODO
 * @createTime 2022年07月15日 09:47:00
 */
public interface Visitor<T> {
    T visit(Square element);
    T visit(Circle element);
    T visit(Rectangle element);
}
