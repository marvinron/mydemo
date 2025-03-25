package com.maviron.spring.springdemo.dynamic;


import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyFactory {

    private static final Map<String, FieldProcessingStrategy> strategies = new ConcurrentHashMap<>();

    static {
        //静态加载
//        registerStrategy(new UsernameStrategy());
//        registerStrategy(new AgeStrategy());
        //SPI加载
        ServiceLoader<FieldProcessingStrategy> loader =
                ServiceLoader.load(FieldProcessingStrategy.class);

        for (FieldProcessingStrategy strategy : loader) {
            strategies.put(strategy.supportedField(), strategy);
            System.out.println("Loaded strategy: " + strategy.getClass().getName());
        }
        //注解加载 @AutoService
    }

    public static void registerStrategy(FieldProcessingStrategy strategy) {
        strategies.put(strategy.supportedField(), strategy);
    }

    public static FieldProcessingStrategy getStrategy(String field) {
        return strategies.get(field);
    }
}
