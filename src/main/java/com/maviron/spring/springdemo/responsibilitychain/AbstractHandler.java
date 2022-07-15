package com.maviron.spring.springdemo.responsibilitychain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstractHandler.java
 * @Description 责任链的抽象
 * @createTime 2022年07月04日 10:00:00
 */
public abstract class AbstractHandler {
    /**
     * 下一关当前抽象类来接收
     */
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract int handler();
}

