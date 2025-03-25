package com.maviron.spring.springdemo.dynamic.feildstrategy;

import com.google.auto.service.AutoService;
import com.maviron.spring.springdemo.dynamic.FieldProcessingStrategy;

@AutoService(FieldProcessingStrategy.class)
public class AgeStrategy implements FieldProcessingStrategy {
    @Override
    public String supportedField() {
        return "age";
    }

    @Override
    public Object process(Object value) {
        Integer age = Integer.valueOf((String) value);
        if (age != null && age > 0) {
            return age;
        }
        return 0;
    }
}
