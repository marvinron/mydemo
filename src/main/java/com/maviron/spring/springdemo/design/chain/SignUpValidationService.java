package com.maviron.spring.springdemo.design.chain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SignUpValidationService.java
 * @Description TODO
 * @createTime 2023年05月06日 16:43:00
 */
public interface SignUpValidationService {
    ValidationResult validate(SignUpCommand command);
}
