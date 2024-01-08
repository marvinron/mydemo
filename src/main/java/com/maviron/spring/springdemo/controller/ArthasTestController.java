package com.maviron.spring.springdemo.controller;

import cn.hutool.core.date.StopWatch;
import com.maviron.spring.springdemo.function.truefalsehandle.BranchHandleUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ArthasTestController.java
 * @Description arthas测试
 * @createTime 2023年05月09日 12:21:00
 */
@RestController
@RequestMapping("/bloom")
public class ArthasTestController {

    @RequestMapping("test")
    public String test() throws Exception {
        return "";
    }





}
