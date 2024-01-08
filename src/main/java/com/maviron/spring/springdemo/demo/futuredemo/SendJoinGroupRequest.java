package com.maviron.spring.springdemo.demo.futuredemo;


public class SendJoinGroupRequest extends AbstractRequestSend implements ResponseHandleAdapter {
    public void sendJoinGroupRequest(String s) {
        send(s).compose(this);
    }

    @Override
    public void onSuccess(String s) {
        System.out.println("SendJoinGroupRequest 执行结果 " + s);
    }

    public static void main(String[] args) {
        SendJoinGroupRequest sendJoinGroupRequest = new SendJoinGroupRequest();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> sendJoinGroupRequest.sendJoinGroupRequest("测试发送sendJoinGroupRequest的请求 ")).start();
            new Thread(() -> sendJoinGroupRequest.sendJoinGroupRequest("测试发送sebdJoinGroupRequest2的请求 ")).start();
        }

    }

}
