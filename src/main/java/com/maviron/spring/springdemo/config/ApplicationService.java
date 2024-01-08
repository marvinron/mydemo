package com.maviron.spring.springdemo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ApplicationService.java
 * @Description TODO
 * @createTime 2023年11月24日 11:31:00
 */
@Configuration
public class ApplicationService implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy......");
    }
}
