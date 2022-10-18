package com.maviron.spring.springdemo.redisdistributedlock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RedisLockTestController.java
 * @Description redis分布式锁的测试接口
 * @createTime 2022年10月18日 14:42:00
 */
@RestController
@RequestMapping("redisLock")
@Slf4j
public class RedisLockTestController {
    @GetMapping("/testRedisLock")
    @RedisLockAnnotation(typeEnum = RedisLockTypeEnum.ONE, lockTime = 3)
    public Book testRedisLock(@RequestParam("userId") Long userId) {
        try {
            log.info("睡眠执行前");
            Thread.sleep(10000);
            log.info("睡眠执行后");
        } catch (Exception e) {
            // log error
            log.info("has some error", e);
        }
        return null;
    }
}
