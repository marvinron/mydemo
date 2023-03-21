package com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest.code;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HelloServiceImplV1.java
 * @Description helloService的实现类V1
 * @createTime 2023年03月15日 20:19:00
 */
@Service
public class HelloServiceImplV1 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello from V1");
    }

    @Override
    public void sayHi() {
        System.out.println("Hi from V1");
    }
}
