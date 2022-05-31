package com.maviron.spring.springdemo.demo.futuredemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public abstract class AbstractRequestSend {
    //模拟异步执行任务
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RequestFuture send(String s) {
        RequestFuture requestFuture = new RequestFuture();
        executorService.execute(new AsyncExeRemoteInvoke(requestFuture,s));
        return requestFuture;
    }

    private static class AsyncExeRemoteInvoke implements Runnable {
        private RequestFuture requestFuture;
        private String s;

        public AsyncExeRemoteInvoke(RequestFuture requestFuture, String s) {
            this.requestFuture = requestFuture;
            this.s= s;
        }
        @Override
        public void run() {
            //模拟远程调用耗时
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String result = "远程调用结束 " + s;
            requestFuture.onComplete(result);
        }
    }

}
