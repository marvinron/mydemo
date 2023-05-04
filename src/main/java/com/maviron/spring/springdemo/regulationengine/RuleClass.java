package com.maviron.spring.springdemo.regulationengine;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.support.composite.UnitRuleGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RuleClass.java
 * @Description 规则引擎
 * @createTime 2023年05月04日 14:32:00
 */
public class RuleClass {
    @Rule(priority = 1)
    public static class FizzRule {
        @Condition
        public boolean isFizz(@Fact("number") Integer number) {
            return number % 5 == 0;
        }

        @Action
        public void printFizz(@Fact("result") Map<String, String> result) {
            result.put("isFizz","number % 5校验不通过");
            //System.out.println("FizzRule");
        }
    }

    @Rule(priority = 2)
    public static class BuzzRule {
        @Condition
        public boolean isBuzz(@Fact("number") Integer number) {
            return number % 7 == 0;
        }

        @Action
        public void printBuzz(@Fact("result") Map<String, String> result) {
            result.put("isBuzz","number % 7校验不通过");
            //System.out.println("isBuzz");
        }
    }

    public static class FizzBuzzRule extends UnitRuleGroup {

        public FizzBuzzRule(Object... rules) {
            for (Object rule : rules) {
                addRule(rule);
            }
        }

        @Override
        public int getPriority() {
            return 0;
        }

    }

    @Rule(priority = 3)
    public static class NonFizzBuzzRule {

        @Condition
        public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
            // can return true, because this is the latest rule to trigger according to
            // assigned priorities
            // and in which case, the number is not fizz nor buzz
            return number % 5 != 0 || number % 7 != 0;
        }

        @Action
        public void printInput(@Fact("result") Map<String, String> result) {
            result.put("NonFizzBuzzRule","number % 5 != 0 || number % 7 != 0");
            //System.out.println("NonFizzBuzzRule");
        }
    }

    public static void main(String[] args) {
        RulesEngineParameters parameters = new RulesEngineParameters()
                .skipOnFirstAppliedRule(true);
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        //rules.register(new RuleClass.FizzBuzzRule(new RuleClass.FizzRule(), new RuleClass.BuzzRule()));
        rules.register(new NonFizzBuzzRule());

        Facts facts = new Facts();
        for (int i = 1; i <= 5; i++) {
            Map<String, String> result = new HashMap<>();
            facts.put("number", i);
            facts.put("result", result);
            rulesEngine.fire(rules, facts);
            //Map<org.jeasy.rules.api.Rule, Boolean> check = rulesEngine.check(rules, facts);
            System.out.println(result);
        }
    }

}
