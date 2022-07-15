package com.maviron.spring.springdemo.design.decorate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DefaultFunctionSalaryCalculator.java
 * @Description TODO
 * @createTime 2022年07月14日 17:42:00
 */
public class DefaultSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculate(double grossAnnual) {
        return grossAnnual / 12;
    }
}
