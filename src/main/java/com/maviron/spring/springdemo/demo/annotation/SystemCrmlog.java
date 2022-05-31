package com.maviron.spring.springdemo.demo.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemCrmlog {
    /**
     * 操作描述
     * 对什么表格进行了什么操作
     *
     * @return
     */
    String description() default "";

    /**
     * 操作的表名
     *
     * @return
     */
    String tableName() default "";
}
