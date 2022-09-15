package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.entity.AdsBrand;
import com.maviron.spring.springdemo.service.AdsBrandService;
import com.maviron.spring.springdemo.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SublistTableController.java
 * @Description 分表测试类
 * @createTime 2022年07月15日 16:10:00
 */
@RestController
@RequestMapping("sublistTable")
public class SublistTableController {
    @Autowired
    private AdsBrandService adsBrandService;
    @RequestMapping("test")
    public Result getAdsBrand(){
        AdsBrand adsBrand = adsBrandService.test(1);
        return Result.success(adsBrand);
    }
}
