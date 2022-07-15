package com.maviron.spring.springdemo.design.decorate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName GeneralTaxDecorator.java
 * @Description
 * @createTime 2022年07月14日 17:48:00
 */
public class GeneralTaxDecorator extends AbstractTaxDecorator {


    public GeneralTaxDecorator(SalaryCalculator salaryCalculator) {
        super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
        return Taxes.generalTax(salary);
    }
}
