package com.maviron.spring.springdemo.design.chain;

import lombok.Value;

import javax.validation.constraints.*;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SignUpCommand.java
 * @Description TODO
 * @createTime 2023年05月06日 16:35:00
 */
@Value
public class SignUpCommand {

    @Min(2)
    @Max(40)
    @NotBlank
    private final String firstName;

    @Min(2)
    @Max(40)
    @NotBlank
    private final String lastName;

    @Min(2)
    @Max(40)
    @NotBlank
    private final String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private final String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private final String rawPassword;

}
