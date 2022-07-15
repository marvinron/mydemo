package com.maviron.spring.springdemo.design.decorate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RegionalTaxDecorator.java
 * @Description TODO
 * @createTime 2022年07月14日 17:52:00
 */
public class RegionalTaxDecorator extends AbstractTaxDecorator {
    public RegionalTaxDecorator(SalaryCalculator salaryCalculator) {
        super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
        return Taxes.regionalTax(salary);
    }
}
