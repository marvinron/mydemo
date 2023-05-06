package com.maviron.spring.springdemo.piplinedesign.piplinecontext;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyPipeline.java
 * @Description TODO
 * @createTime 2023年05月06日 11:23:00
 */
public class MyPipeline {
    private HandlerContext head;//链表头
    private HandlerContext tail;//链表尾，如果是一个双向链表，这个成员将会被用到，netty就使用的双向链表，因为是全双工的。

    public void addFirst(Handler handler) {
        HandlerContext ctx = new HandlerContext(handler);
        HandlerContext temp = head;
        head = ctx;
        head.setNext(temp);
    }
    public void Request(Object msg){//封装了外部调用接口
        head.doWork(msg);
    }

    public MyPipeline() {
        head = tail = new HeadContext(new HeadHandler());
    }

    final class HeadContext extends HandlerContext {//这是一个内部类，为默认handler的context

        public HeadContext(Handler handler) {
            super(handler);
        }
    }

    final class HeadHandler implements Handler {//这是一个内部类，是pipeline的默认处理handler。

        @Override
        public void channelRead(HandlerContext ctx, Object msg) {
            String result = msg + "end";
            System.out.println(result);
        }
    }


}
