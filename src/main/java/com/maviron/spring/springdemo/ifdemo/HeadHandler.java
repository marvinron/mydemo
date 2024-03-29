package com.maviron.spring.springdemo.ifdemo;

import org.apache.commons.lang3.StringUtils;

// 首节点，判断 actionCode 是否为空
public class HeadHandler extends ActionHandler{

    @Override
    public void doHandler(String actionCode) {
        if (StringUtils.isBlank(actionCode)) {
            throw new RuntimeException("actionCode 不能为空");
        }

        successorBack.doHandler(actionCode);
    }
}