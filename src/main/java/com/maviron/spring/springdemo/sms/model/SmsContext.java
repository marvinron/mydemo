package com.maviron.spring.springdemo.sms.model;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsContext.java
 * @Description 短信上下文
 * @createTime 2022年05月11日 18:26:00
 */
public class SmsContext {
    /**
     * 电话
     */
    private String mobile;
    /**
     * 发送内容
     */
    private String content;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
