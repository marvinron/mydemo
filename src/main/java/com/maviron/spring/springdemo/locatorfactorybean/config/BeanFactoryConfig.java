package com.maviron.spring.springdemo.locatorfactorybean.config;

import com.maviron.spring.springdemo.locatorfactorybean.TestBeanFactoryProxy;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BeanFactoryConfig.java
 * @Description TODO
 * @createTime 2024年06月24日 14:45:00
 */
@Configuration
public class BeanFactoryConfig {
    @Bean
    public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean dataWarehouseFactory = new ServiceLocatorFactoryBean();
        dataWarehouseFactory.setServiceLocatorInterface(TestBeanFactoryProxy.class);
        return dataWarehouseFactory;
    }
}
