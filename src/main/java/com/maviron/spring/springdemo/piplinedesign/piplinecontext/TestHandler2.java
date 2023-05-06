package com.maviron.spring.springdemo.piplinedesign.piplinecontext;

public class TestHandler2 implements Handler {
    @Override
    public void channelRead(HandlerContext ctx, Object msg) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = msg + "-handler2";
        System.out.println(result);
        ctx.write(result);
    }
}  
