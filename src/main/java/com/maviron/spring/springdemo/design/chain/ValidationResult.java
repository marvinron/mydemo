package com.maviron.spring.springdemo.design.chain;

import lombok.Value;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ValidationResult.java
 * @Description TODO
 * @createTime 2023年05月06日 16:37:00
 */
@Value
public class ValidationResult {
    private final boolean isValid;
    private final String errorMsg;

    public static ValidationResult valid() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult invalid(String errorMsg) {
        return new ValidationResult(false, errorMsg);
    }

    public boolean notValid() {
        return !isValid;
    }
}
