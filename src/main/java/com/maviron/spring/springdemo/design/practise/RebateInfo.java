package com.maviron.spring.springdemo.design.practise;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RebateInfo.java
 * @Description 通用的消息体
 * @createTime 2023年05月10日 16:28:00
 */
public class RebateInfo {
    private String userId;  // 用户ID
    private String bizId;   // 业务ID
    private Long bizTime;   // 业务时间
    private String desc;    // 业务描述

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Long getBizTime() {
        return bizTime;
    }

    public void setBizTime(Long bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
