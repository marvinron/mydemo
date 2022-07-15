package com.maviron.spring.springdemo.design.decorate;

import com.maviron.spring.springdemo.function.functionmode.DefaultFunctionSalaryCalculator;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 装饰模式测试
 * @createTime 2022年07月14日 17:55:00
 */
public class Test {

    public static void main(String[] args) {
        //double netSalary = new HealthInsuranceDecorator(
        //        new RegionalTaxDecorator(
        //                new GeneralTaxDecorator(
        //                        new DefaultFunctionSalaryCalculator()
        //                )
        //        )
        //).calculate( 30000.00 );
        //System.out.println(netSalary);

        //函数的装饰模式
        double v = new DefaultFunctionSalaryCalculator()
                .andThen(Taxes::generalTax)
                .andThen(Taxes::regionalTax)
                .andThen(Taxes::healthInsurance)
                .applyAsDouble(30000);
        System.out.println(v);
    }
}
