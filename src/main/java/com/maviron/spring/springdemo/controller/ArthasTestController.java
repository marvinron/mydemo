package com.maviron.spring.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ArthasTestController.java
 * @Description arthas测试
 * @createTime 2023年05月09日 12:21:00
 */
@RestController
@RequestMapping("/arthas")
public class ArthasTestController {

    @RequestMapping("test")
    public String test() throws Exception {
        doMethodA();
        doMethodB();
        doMethodC();
        return "arthas 测试接口时间 ";
    }

    private void doMethodC() throws Exception{
        Thread.sleep(3000);
    }

    private void doMethodB() throws Exception {
        Thread.sleep(2000);

    }

    private void doMethodA() throws Exception {
        Thread.sleep(1000);
    }

}
