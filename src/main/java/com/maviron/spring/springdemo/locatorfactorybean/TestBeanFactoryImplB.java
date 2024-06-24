package com.maviron.spring.springdemo.locatorfactorybean;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestBeanFactoryImplB.java
 * @Description 业务实现接口B
 * @createTime 2024年06月24日 14:39:00
 */
@Service("B")
public class TestBeanFactoryImplB implements TestBeanFactory {
    @Override
    public String getBeanName() {
        return TestBeanFactoryImplB.class.getName();
    }
}
