package com.maviron.spring.springdemo.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Object> input = new HashMap<>();
        input.put("username", "JohnDoe  ");
        input.put("age", "20");
        input.put("email", "test@example.com"); // 未注册字段
        try {
            FeildProcessor feildProcessor = new FeildProcessor();
            Map<String, Object> result = feildProcessor.processFields(input);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
