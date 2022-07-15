package com.maviron.spring.springdemo.function.functionmode;

import java.util.function.DoubleUnaryOperator;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DefaultFunctionSalaryCalculator.java
 * @Description 函数式默认处理方法
 * @createTime 2022年07月14日 18:26:00
 */
public class DefaultFunctionSalaryCalculator implements DoubleUnaryOperator {
    @Override
    public double applyAsDouble(double grossAnnual) {
        return grossAnnual / 12;
    }
}
