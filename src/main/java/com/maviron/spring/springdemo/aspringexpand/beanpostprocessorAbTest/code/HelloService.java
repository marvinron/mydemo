package com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest.code;

import com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest.RoutingSwitch;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HelloService.java
 * @Description
 * @createTime 2023年03月15日 20:16:00
 */
//@RoutingSwitch("hello.switch")
public interface HelloService {

    @RoutingSwitch("A")
    void sayHello();

    void sayHi();
}
