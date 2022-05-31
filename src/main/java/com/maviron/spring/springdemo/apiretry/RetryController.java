package com.maviron.spring.springdemo.apiretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RetryController.java
 * @Description 重试接口
 * @createTime 2022年05月11日 15:51:00
 */
@RestController
@RequestMapping("test")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @RequestMapping("retry")
    public void retryCount() {
       retryService.retryTimes();
    }
}
