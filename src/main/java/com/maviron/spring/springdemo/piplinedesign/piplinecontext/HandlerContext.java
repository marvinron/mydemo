package com.maviron.spring.springdemo.piplinedesign.piplinecontext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HandlerContext.java
 * @Description 处理的上下文
 * @createTime 2023年05月06日 09:59:00
 */
public class HandlerContext {
    private ExecutorService executor = Executors.newCachedThreadPool();//线程池
    private Handler handler;
    private HandlerContext next;//下一个context的引用

    public HandlerContext(Handler handler) {
        this.handler = handler;
    }

    public void setNext(HandlerContext ctx) {
        this.next = ctx;
    }

    public void doWork(Object msg) { //执行任务的时候向线程池提交一个runnable的任务，任务中调用handler
        if (next == null) {
            return;
        } else {
            executor.submit(() -> handler.channelRead(next, msg));
        }
    }

    //这里的write操作是给handler调用的，实际上是一个回调方法，
    // 当handler处理完数据之后，调用一下nextcontext.write，此时就把任务传递给下一个handler了。
    public void write(Object msg) {
        doWork(msg);
    }
}
