package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.event.MyPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EventListenerController.java
 * @Description
 * @createTime 2022年04月15日 16:32:00
 */
@RestController
@RequestMapping("event")
public class EventListenerController {

    @Autowired
    private MyPublisher myPublisher;

    @RequestMapping("test")
    public void test(String id) {

        myPublisher.publishEvent(id);
    }
}
