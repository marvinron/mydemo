package com.maviron.spring.springdemo.actor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.*;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ServerHandler.java
 * @Description TODO
 * @createTime 2023年07月13日 15:02:00
 */
public class ServerHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        ActorSystem.send(msg);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 2, 7, 5);

        Integer integer = numbers.stream()
                .max(Comparator.comparingInt(x -> (int) x).thenComparingInt(x -> new Random().nextInt()))
                .orElse(null);
        System.out.println(integer);
    }
}
