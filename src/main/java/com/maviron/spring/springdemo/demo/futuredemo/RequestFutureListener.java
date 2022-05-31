package com.maviron.spring.springdemo.demo.futuredemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName RequestFutureListener.java
 * @Description TODO
 * @createTime 2021年11月23日 14:37:00
 */
public interface RequestFutureListener {
    void onSuccess(String string);
    void onFail();
}
