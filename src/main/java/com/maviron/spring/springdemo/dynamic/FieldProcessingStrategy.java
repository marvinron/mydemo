package com.maviron.spring.springdemo.dynamic;

public interface FieldProcessingStrategy {
    /**
     * @return 处理的字段名称
     */
    String supportedField();

    /**
     * 处理字段的值
     *
     * @param value
     * @return
     */
    Object process(Object value);
}
