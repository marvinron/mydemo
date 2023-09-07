package com.maviron.spring.springdemo.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CGLibRetryProxyHandler.java
 * @Description cglib动态代理
 * @createTime 2023年08月02日 10:00:00
 */
@Component
public class CGLibRetryProxyHandler implements MethodInterceptor {
    private Object target;


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        int times = 1;
        while (times <= 5) {
            try {
                int i = 3 / 0;
                return method.invoke(target, objects);
            } catch (Exception e) {
                System.out.println("重试了 " + times + " 次");
                try {

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                times++;
                if (times > 5) {
                    throw new RuntimeException("不再重试！");
                }
            }
        }
        return null;
    }

    public Object getCglibProxy(Object objectTarget) {
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }
}
