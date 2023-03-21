package com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest.code;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HelloServiceImplV2.java
 * @Description helloService的实现类V2
 * @createTime 2023年03月15日 20:20:00
 */
@Service
public class HelloServiceImplV2 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello from V2");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from V2");
    }
}
