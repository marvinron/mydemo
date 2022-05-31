package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.demo.annotation.SystemCrmlog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2022年01月10日 09:24:00
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add")
    @SystemCrmlog(description = "对User表进行添加操作")
    public String add() {

        return "success";
    }


}
