package com.maviron.spring.springdemo.demo.futuredemo;


public class SendJoinGroupRequest extends AbstractRequestSend implements ResponseHandleAdapter {
   public void sendJoinGroupRequest(String s){
       send(s).compose(this);
   }
    @Override
    public void onSuccess(String s) {
        System.out.println("SendJoinGroupRequest 执行结果 "+s);
    }

    public static void main(String[] args) {
        SendJoinGroupRequest sendJoinGroupRequest = new SendJoinGroupRequest();
        sendJoinGroupRequest.sendJoinGroupRequest("测试发送sendJoinGroupRequest的请求");

    }

}
