package com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RoutingBeanPostProcessor.java
 * @Description RoutingBeanPostProcessor处理
 * @createTime 2023年03月15日 20:28:00
 */
@Component
public class RoutingBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(RoutingInjected.class)) {
                if (!field.getType().isInterface()) {
                    throw new RuntimeException("");
                }
                try {
                    this.handleRoutingInjected(field, bean, field.getType());
                } catch (Exception e) {
                    throw new RuntimeException("exception throw when handleAutowireRouting");
                }
            }
        }
        return bean;
    }


    private void handleRoutingInjected(Field field, Object bean, Class type) throws Exception {
        Map<String, Object> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if (candidates.size() == 1) {
            field.set(bean, candidates.values().iterator().next());
        } else if (candidates.size() == 2) {
            Object proxy = RoutingBeanProxyFactory.createProxy(type, candidates);
            field.set(bean, proxy);
        } else {
            throw new IllegalArgumentException("find more than 2 beans for type：" + type);
        }

    }

}