package com.maviron.spring.springdemo.design.visitor;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PerimeterVisitor.java
 * @Description 访问者模式的周长
 * @createTime 2022年07月15日 11:03:00
 */
public class PerimeterVisitor implements Visitor<Double> {
    @Override
    public Double visit(Square element) {
        return 4 * element.side;
    }

    @Override
    public Double visit(Circle element) {
        return 2 * Math.PI * element.radius;
    }

    @Override
    public Double visit(Rectangle element) {
        return (2 * element.width + 2 * element.height);
    }
}
