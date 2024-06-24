package com.maviron.spring.springdemo.locatorfactorybean.controller;

import com.maviron.spring.springdemo.locatorfactorybean.TestBeanFactoryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description 测试servicelocaterbeanfactory
 * @createTime 2024年06月24日 14:50:00
 * @see org.springframework.beans.factory.config.ServiceLocatorFactoryBean
 */
@RestController
@RequestMapping("test")
public class TestBeanFactoryProxyController {
    private TestBeanFactoryProxy testBeanFactoryProxy;

    @Autowired
    public TestBeanFactoryProxyController(TestBeanFactoryProxy testBeanFactoryProxy) {
        this.testBeanFactoryProxy = testBeanFactoryProxy;
    }

    @RequestMapping("/testService")
    public String getService() {
        String a = testBeanFactoryProxy.get("A").getBeanName();
        System.out.println(a);
        String c = testBeanFactoryProxy.get("C").getBeanName();
        System.out.println(c);
        return c;

    }
}
