package com.maviron.spring.springdemo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyEventListener.java
 * @Description TODO
 * @createTime 2022年04月15日 16:30:00
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("我监听到消息了。。。。。");
        String args = event.getArgs();
        System.out.println("获取到参数了 "+args);
    }
}
