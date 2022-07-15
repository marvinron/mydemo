package com.maviron.spring.springdemo.design.decorate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstractTaxDecorator.java
 * @Description TODO
 * @createTime 2022年07月14日 17:43:00
 */
public abstract class AbstractTaxDecorator implements SalaryCalculator {

    private final SalaryCalculator salaryCalculator;
    public AbstractTaxDecorator( SalaryCalculator salaryCalculator ) {
        this.salaryCalculator = salaryCalculator;
    }

    protected abstract double applyTax(double salary);

    @Override
    public final double calculate(double gross) {
        double salary = salaryCalculator.calculate( gross );
        return applyTax( salary );
    }

}
