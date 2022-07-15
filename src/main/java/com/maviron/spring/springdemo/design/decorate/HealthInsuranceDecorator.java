package com.maviron.spring.springdemo.design.decorate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HealthInsuranceDecorator.java
 * @Description TODO
 * @createTime 2022年07月14日 17:53:00
 */
public class HealthInsuranceDecorator extends AbstractTaxDecorator {
    public HealthInsuranceDecorator(SalaryCalculator salaryCalculator) {
        super(salaryCalculator);
    }

    @Override
    protected double applyTax(double salary) {
        return Taxes.healthInsurance(salary);
    }
}
