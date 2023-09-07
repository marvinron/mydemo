package com.maviron.spring.springdemo.condition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestCondition.java
 * @Description TODO
 * @createTime 2023年09月07日 10:19:00
 */
public class TestCondition {
    public static void main(String[] args) {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition1());
        conditions.add(new Condition2());
        // 添加其他条件...
        ConditionEvaluator evaluator = new ConditionEvaluator(conditions);
        if(evaluator.evaluate()) {
            // 执行操作
        }
    }


}
