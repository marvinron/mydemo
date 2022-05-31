package com.maviron.spring.springdemo.sms.model;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsSendParam.java
 * @Description 发送短信参数
 * @createTime 2022年05月11日 18:31:00
 */
public class SmsSendParam {

    /**
     * 短信模板code
     */
    private Integer templateCode;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 占位符参数
     */
    private SmsPlaceHolderParameter parameter;

    public Integer getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(Integer templateCode) {
        this.templateCode = templateCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public SmsPlaceHolderParameter getParameter() {
        return parameter;
    }

    public void setParameter(SmsPlaceHolderParameter parameter) {
        this.parameter = parameter;
    }
}
