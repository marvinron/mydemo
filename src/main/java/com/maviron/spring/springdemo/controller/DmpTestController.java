package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.entity.DmpTest;
import com.maviron.spring.springdemo.service.DmpTestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 媒体应用包名(DmpTest)表控制层
 *
 * @author makejava
 * @since 2023-03-21 10:13:45
 */
@RestController
@RequestMapping("dmpTest")
public class DmpTestController {
    /**
     * 服务对象
     */
    @Resource
    private DmpTestService dmpTestService;



}
