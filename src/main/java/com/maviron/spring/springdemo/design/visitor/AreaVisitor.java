package com.maviron.spring.springdemo.design.visitor;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AreaVisitor.java
 * @Description 访问者模式的面积处理
 * @createTime 2022年07月15日 11:00:00
 */
public class AreaVisitor implements Visitor<Double> {
    @Override
    public Double visit(Square element) {
        return element.side * element.side;
    }

    @Override
    public Double visit(Circle element) {
        return Math.PI * element.radius * element.radius;
    }

    @Override
    public Double visit(Rectangle element) {
        return element.width * element.height;
    }
}
