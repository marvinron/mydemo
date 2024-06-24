package com.maviron.spring.springdemo.locatorfactorybean;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestBeanFactoryImplC.java
 * @Description 继承抽象类并实现接口方法
 * @createTime 2024年06月24日 17:08:00
 */
@Service("C")
public class TestBeanFactoryImplC extends AbstractTestBeanFactory {
    @Override
    public String getBeanName() {
        return TestBeanFactoryImplC.class.getName();
    }
}
