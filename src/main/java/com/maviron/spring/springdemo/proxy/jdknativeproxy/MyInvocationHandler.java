package com.maviron.spring.springdemo.proxy.jdknativeproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyInvocationHandler.java
 * @Description TODO
 * @createTime 2022年04月24日 10:44:00
 */
public class MyInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在目标对象执行之前先简单打印一下
        System.out.println("--------------before--------------");
        Object result = method.invoke(target, args);
        //在目标对象执行之后打印一下
        System.out.println("--------------after---------------");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(), this);
    }
}
