package com.maviron.spring.springdemo.controller;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DemoController.java
 * @Description TODO
 * @createTime 2022年03月14日 20:01:00
 */
@RestController
@RequestMapping("test")
public class DemoController {
    @RequestMapping("method")
    public String addMethod()  throws Exception{
        //File file = new File("123.txt");
        //FileUtils.write(file,"这是个test_txt",Charsets.toCharset("UTF-8"));
       return "true";
    }
}
