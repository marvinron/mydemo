package com.maviron.spring.springdemo.proxy.jdknativeproxy;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description 代理接口的实现类
 * @createTime 2022年04月24日 10:56:00
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("逻辑执行了哈。。。。。。");
    }
}
