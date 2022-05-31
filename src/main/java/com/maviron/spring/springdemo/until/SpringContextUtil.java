package com.maviron.spring.springdemo.until;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author poker.li
 * @date 2021/7/10 14:37
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    @Nullable
    public static <T> T getBean(String beanName) {
        //noinspection unchecked
        return (T) applicationContext.getBean(beanName);
    }

    @Nullable
    public static <T> T getBean(Class<? extends T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Nullable
    public static <T> T getBean(String beanName, Class<? extends T> clazz) {
        return applicationContext.getBean(beanName, clazz);
    }

}
