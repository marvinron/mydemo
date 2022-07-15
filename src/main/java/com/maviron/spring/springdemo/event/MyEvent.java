package com.maviron.spring.springdemo.event;

import com.maviron.spring.springdemo.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyEvent.java
 * @Description
 * @createTime 2022年04月15日 16:18:00
 * @see org.springframework.context.ApplicationEvent
 */
public class MyEvent extends ApplicationEvent {
    private String args;
    public MyEvent(Object source) {
        super(source);
    }
    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }


}
