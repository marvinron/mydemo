package com.maviron.spring.springdemo.piplinedesign.piplinecontext;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Handler.java
 * @Description 处理类接口
 * @createTime 2023年05月06日 09:58:00
 */
public interface Handler {
    void channelRead(HandlerContext ctx, Object msg);
}
