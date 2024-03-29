package com.maviron.spring.springdemo.ifdemo;

public class ActionHandler2 extends ActionHandler {

    @Override
    public void doHandler(String actionCode) {
        if ("action2".equals(actionCode)) {
            doAction2();
        } else {
            // 传递到下一个节点
            successorBack.doHandler(actionCode);
        }
    }

    /**
     * 执行
     */
    private void doAction2() {

    }
}