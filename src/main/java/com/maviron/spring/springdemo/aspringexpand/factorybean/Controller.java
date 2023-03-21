package com.maviron.spring.springdemo.aspringexpand.factorybean;

import com.maviron.spring.springdemo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Controller.java
 * @Description 测试controller
 * @createTime 2023年03月15日 18:19:00
 */
@RestController
@RequestMapping("request")
public class Controller {
    @Resource
    private User user;
    @RequestMapping("expand")
    public String getUserFactory() {
        return user.toString();
    }
}
