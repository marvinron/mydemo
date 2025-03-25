package com.maviron.spring.springdemo.dynamic;

import java.util.HashMap;
import java.util.Map;

public class FeildProcessor {
    public Map<String, Object> processFields(Map<String, Object> input) {
        Map<String, Object> result = new HashMap<>();
        input.forEach((k, v) -> {
            FieldProcessingStrategy strategy = StrategyFactory.getStrategy(k);
            if (strategy != null) {
                result.put(k, strategy.process(v));
            }
        });
        return result;
    }
}
