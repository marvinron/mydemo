package com.maviron.spring.springdemo.dynamic.feildstrategy;

import com.google.auto.service.AutoService;
import com.maviron.spring.springdemo.dynamic.FieldProcessingStrategy;
import jodd.util.StringUtil;

@AutoService(FieldProcessingStrategy.class)
public class UsernameStrategy implements FieldProcessingStrategy {
    @Override
    public String supportedField() {
        return "username";
    }

    @Override
    public Object process(Object value) {
        String username = (String) value;
        if (StringUtil.isNotBlank(username)) {
            return username;
        }
        return "";
    }
}
