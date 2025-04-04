package com.maviron.spring.springdemo.design.chain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ValidationStep.java
 * @Description TODO
 * @createTime 2023年05月06日 16:40:00
 */
public abstract class ValidationStep<T> {
    private ValidationStep<T> next;

    public ValidationStep<T> linkWith(ValidationStep<T> next) {
        if (this.next == null) {
            this.next = next;
            return this;
        }
        ValidationStep<T> lastStep = this.next;
        while (lastStep.next != null) {
            lastStep = lastStep.next;
        }
        lastStep.next = next;
        return this;
    }

    public abstract ValidationResult validate(T toValidate);

    protected ValidationResult checkNext(T toValidate) {
        if (next == null) {
            return ValidationResult.valid();
        }

        return next.validate(toValidate);
    }
}
