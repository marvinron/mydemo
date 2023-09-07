package com.maviron.spring.springdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RetryInvocationHandler.java
 * @Description TODO
 * @createTime 2023年08月02日 09:45:00
 */
public class RetryInvocationHandler implements InvocationHandler {

    private final Object subject;

    public RetryInvocationHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int times = 1;
        while (times < 5) {
            try {
                int i = 3 / 0;
                return method.invoke(subject, args);
            } catch (Exception e) {
                System.out.println("重试了 " + times + " 次");
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                times++;
                if (times > 5) {
                    throw new RuntimeException("不再重试 ！");
                }

            }
        }
        return null;
    }

    public Object getProxy(Object realObject) {
        InvocationHandler handler = new RetryInvocationHandler(realObject);
        return Proxy.newProxyInstance(handler.getClass().getClassLoader(), realObject.getClass().getInterfaces(), handler);
    }
}
