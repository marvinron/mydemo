package com.maviron.spring.springdemo.proxy.jdknativeproxy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        //UserService userService = new UserServiceImpl();
        ////实例化一个handler
        //MyInvocationHandler handler = new MyInvocationHandler(userService);
        ////获取一个代理对象
        //UserService userServiceProxy = (UserService)handler.getProxy();
        //ExecutorService service = Executors.newFixedThreadPool(2);
        //userServiceProxy.add();
        List<String> list = new ArrayList<>();
        list.add("12312");
        list.add("1000");
        list.add("12000");
        String[] strings = list.toArray(new String[list.size()]);
        System.out.println(strings);

    }
}
