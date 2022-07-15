package com.maviron.spring.springdemo.design.visitor;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Square.java
 * @Description 方形
 * @createTime 2022年07月15日 09:48:00
 */
public class Square implements Element {
    public final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return null;
    }
}
