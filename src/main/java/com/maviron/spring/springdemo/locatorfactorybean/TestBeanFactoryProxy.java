package com.maviron.spring.springdemo.locatorfactorybean;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestBeanFactoryProxy.java
 * @Description 测试代理接口
 * @createTime 2024年06月24日 14:44:00
 */
public interface TestBeanFactoryProxy {
    TestBeanFactory get(String type);
}
