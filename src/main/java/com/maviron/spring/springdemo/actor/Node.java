package com.maviron.spring.springdemo.actor;

import java.net.InetSocketAddress;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Node.java
 * @Description TODO
 * @createTime 2023年07月13日 14:29:00
 */
public abstract class Node {
    /**
     * 名字 唯一的 需要按照名字查找
     */
    private String name;
    /**
     * socket对象
     */
    private InetSocketAddress address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(InetSocketAddress address) {
        this.address = address;
    }
}
