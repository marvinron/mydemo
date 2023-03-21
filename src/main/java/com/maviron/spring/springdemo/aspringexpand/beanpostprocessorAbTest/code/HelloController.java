package com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest.code;

import com.maviron.spring.springdemo.aspringexpand.beanpostprocessorAbTest.RoutingInjected;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description 测试请求入口
 * @createTime 2023年03月15日 20:18:00
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RoutingInjected
    private HelloService helloService;

    @RequestMapping("say")
    public void SayHello() {
        this.helloService.sayHello();
    }

    @RequestMapping("hi")
    public void sayHi() {
        this.helloService.sayHi();
    }


}
