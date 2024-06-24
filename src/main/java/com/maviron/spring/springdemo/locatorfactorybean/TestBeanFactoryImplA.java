package com.maviron.spring.springdemo.locatorfactorybean;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestBeanFactoryImplA.java
 * @Description 业务实现接口A
 * @createTime 2024年06月24日 14:37:00
 */
@Service("A")
public class TestBeanFactoryImplA implements TestBeanFactory {
    @Override
    public String getBeanName() {
        return TestBeanFactoryImplA.class.getName();
    }
}
