package com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingSwitch {
    /**
     * 在配置系统中开关的属性名称 应用系统将实时读取配置的ABtest使用什么版本
     *
     * @return
     */
    String value() default "";
}
