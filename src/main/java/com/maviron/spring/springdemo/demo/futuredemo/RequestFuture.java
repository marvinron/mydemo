package com.maviron.spring.springdemo.demo.futuredemo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RequestFuture {
    private List<RequestFutureListener> requestFutureListenerList;

    public RequestFuture() {
        this.requestFutureListenerList = new ArrayList<>();
    }
    public void onComplete(String s){
        //假设只执行成功的方法
        fireSuccess(s);
    }

    private void fireSuccess(String s) {
        requestFutureListenerList.forEach(requestFutureListener -> requestFutureListener.onSuccess(s));
    }
    private void addRequestFutureListener(RequestFutureListener requestFutureListener){
        requestFutureListenerList.add(requestFutureListener);
    }
    public void compose(ResponseHandleAdapter responseHandleAdapter){
        addRequestFutureListener(new RequestFutureListener() {
            @Override
            public void onSuccess(String s) {
                //交回各个请求处理类进行处理
              responseHandleAdapter.onSuccess(s);
            }

            @Override
            public void onFail() {

                //暂时不处理
            }
        });
    }
}
