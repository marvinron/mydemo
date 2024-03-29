package com.maviron.spring.springdemo.ifdemo;

public abstract class ActionHandler {

    // 后继节点
    protected ActionHandler successorBack;

    /**
     * 处理请求
     * @param actionCode
     */
    public void handler(String actionCode) {
        doHandler(actionCode);
    }

    // 设置后继节点
    protected ActionHandler setSuccessor(ActionHandler successor) {
        this.successorBack = successor;
        return successorBack;
    }

    // 处理请求
    public abstract void doHandler(String actionCode);
}