package com.maviron.spring.springdemo.disrupter.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MessageModel.java
 * @Description 消息体
 * @createTime 2022年06月27日 17:49:00
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class MessageModel {
    private String message;
}
