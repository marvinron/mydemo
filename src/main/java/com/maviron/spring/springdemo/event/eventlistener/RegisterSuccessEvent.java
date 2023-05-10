package com.maviron.spring.springdemo.event.eventlistener;

import lombok.Data;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RegisterSuccessEvent.java
 * @Description 事件对象
 * @createTime 2023年05月10日 15:07:00
 */
@Data
public class RegisterSuccessEvent {
    private String uerName;

    public RegisterSuccessEvent(String userName) {
        this.uerName = userName;
    }
}
