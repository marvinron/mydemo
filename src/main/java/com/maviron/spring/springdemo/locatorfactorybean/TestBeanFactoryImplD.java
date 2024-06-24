package com.maviron.spring.springdemo.locatorfactorybean;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestBeanFactoryImplD.java
 * @Description 继承抽象类并实现接口的方法
 * @createTime 2024年06月24日 17:09:00
 */
@Service("D")
public class TestBeanFactoryImplD extends AbstractTestBeanFactory {
    @Override
    public String getBeanName() {
        return TestBeanFactoryImplD.class.getName();
    }
}
