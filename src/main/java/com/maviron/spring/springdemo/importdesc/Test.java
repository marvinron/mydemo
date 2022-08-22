package com.maviron.spring.springdemo.importdesc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年08月11日 10:14:00
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        ServiceInterface bean = applicationContext.getBean(ServiceInterface.class);
        bean.test();
    }
}
