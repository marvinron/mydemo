package com.maviron.spring.springdemo.ifdemo;

public class ActionHandler1 extends ActionHandler{

    @Override
    public void doHandler(String actionCode) {
        if ("action1".equals(actionCode)) {
            doAction1();
        } else {
            // 传递到下一个节点
            successorBack.doHandler(actionCode);
        }
    }

    /**
     * 执行
     */
    private void doAction1() {
        System.out.println("action1 处理了");
    }


}

