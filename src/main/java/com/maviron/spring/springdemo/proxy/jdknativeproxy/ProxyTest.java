package com.maviron.spring.springdemo.proxy.jdknativeproxy;

import org.junit.Test;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ProxyTest.java
 * @Description 测试代理逻辑
 * @createTime 2022年04月24日 10:57:00
 */
public class ProxyTest {
    @Test
    public void test(){
        UserService userService = new UserServiceImpl();
        //实例化一个handler
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        //获取一个代理对象
        UserService userServiceProxy = (UserService)handler.getProxy();
        userServiceProxy.add();
    }
}
