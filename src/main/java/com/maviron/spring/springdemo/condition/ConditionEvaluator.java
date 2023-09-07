package com.maviron.spring.springdemo.condition;

import java.util.List;

public class ConditionEvaluator {
    private List<Condition> conditions;

    public ConditionEvaluator(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public boolean evaluate() {
        for (Condition condition : conditions) {
            if (!condition.test()) {
                return false;
            }
        }
        return true;
    }
}