package com.maviron.spring.springdemo.sms.model;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsPlaceHolderParameter.java
 * @Description 短信占位符参数
 * @createTime 2022年05月11日 18:27:00
 */
public class SmsPlaceHolderParameter {

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 链接
     */
    private String url;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
