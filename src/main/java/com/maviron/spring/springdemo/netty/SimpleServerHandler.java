package com.maviron.spring.springdemo.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SimpleServerHandler.java
 * @Description TODO
 * @createTime 2022年08月11日 16:45:00
 */
public class SimpleServerHandler extends ChannelInboundHandlerAdapter {
   @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
    }
}
