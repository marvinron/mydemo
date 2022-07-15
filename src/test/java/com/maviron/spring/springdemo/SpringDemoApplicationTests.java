package com.maviron.spring.springdemo;

import com.maviron.spring.springdemo.disrupter.producer.DisruptorMqService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringDemoApplicationTests {
    @Autowired
    private DisruptorMqService disruptorMqService;

    @Test
    public void sayHelloMqTest() throws Exception {
        disruptorMqService.sayHelloMq("消息到了，Hello world!");
        log.info("消息队列已发送完毕");
        //这里停止2000ms是为了确定是处理消息是异步的
        Thread.sleep(2000);
    }

}
