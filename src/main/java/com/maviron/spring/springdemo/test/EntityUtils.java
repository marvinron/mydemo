package com.maviron.spring.springdemo.test;

import cn.hutool.core.date.StopWatch;
import com.maviron.spring.springdemo.entity.User;

import java.lang.reflect.Field;

public class EntityUtils {

    public static <T> T copyNullsFrom(T source, T destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source or destination entity cannot be null");
        }

        try {
            Class<T> sourceClass = (Class<T>) source.getClass();
            Field[] sourceFields = sourceClass.getDeclaredFields();

            for (Field sourceField : sourceFields) {
                sourceField.setAccessible(true);
                Object sourceValue = sourceField.get(source);
                Object destinationValue = sourceField.get(destination);

                if (sourceValue == null && destinationValue != null) {
                    sourceField.set(source, destinationValue);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing fields of class " + source.getClass().getName(), e);
        }

        return source; // 返回更新后的source实体
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        User entityA = new User();
        entityA.setAge(null);
        entityA.setName("adas");

        User entityB = new User();
        entityB.setEmail("asdsa");
        entityB.setSalery(12D);
        for (int i = 0; i < 100; i++) {
            // 复制entityB中的非空值到entityA中
            EntityUtils.copyNullsFrom(entityA, entityB);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
