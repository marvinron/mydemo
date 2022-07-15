package com.maviron.spring.springdemo.design.visitor;

import java.util.Arrays;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 访问者模式测试
 * @createTime 2022年07月15日 11:08:00
 */
public class Test {
    public static void main(String[] args) {
        List<Element> figures = Arrays.asList( new Circle( 4 ), new Square( 5 ), new Rectangle( 6, 7 ));

        double totalArea = 0.0;
        Visitor<Double> areaVisitor = new AreaVisitor();
        for (Element figure : figures) {
            totalArea += figure.accept( areaVisitor );
        }
        System.out.println("Total area = " + totalArea);

        double totalPerimeter = 0.0;
        Visitor<Double> perimeterVisitor = new PerimeterVisitor();
        for (Element figure : figures) {
            totalPerimeter += figure.accept( perimeterVisitor );
        }
        System.out.println("Total perimeter = " + totalPerimeter);
    }
}
