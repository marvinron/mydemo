package com.maviron.spring.springdemo.actor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ClientHandler.java
 * @Description TODO
 * @createTime 2023年07月13日 15:03:00
 */
public class ClientHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        ActorSystem.send(msg.getDestNode(), msg.getDestActor(), msg.getCommand(), msg.getParams());
    }
}
