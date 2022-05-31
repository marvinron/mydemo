package com.maviron.spring.springdemo.apiretry;

import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RetryService.java
 * @Description TODO
 * @createTime 2022年05月11日 16:00:00
 */
@Service("retryService")
public class RetryService {

    @Retry(title = "RetryController", retryTimes = 2, excuteInterval = 500)
    public void retryTimes() {
        System.out.println("进入了业务逻辑.....");

    }
}
