package com.maviron.spring.springdemo.demo.web;


import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ClassUtil {
    public static <A extends Annotation> A getAnnotation(Method method, Class<A> annotationType){
        Class<?> declaringClass = method.getDeclaringClass();
        Method mostSpecificMethod = ClassUtils.getMostSpecificMethod(method, declaringClass);
        Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(mostSpecificMethod);
        A mergedAnnotation = AnnotatedElementUtils.findMergedAnnotation(bridgedMethod, annotationType);
        if(mergedAnnotation != null){
            return mergedAnnotation;
        }
        return AnnotatedElementUtils.findMergedAnnotation(method, annotationType);

    }
}
