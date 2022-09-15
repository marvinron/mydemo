package com.maviron.spring.springdemo.beanequals;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maviron.spring.springdemo.until.BeanCopyUtil;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class AggregateWithDsp implements Serializable {
    private static final long serialVersionUID = -5040251569874672259L;
    String pubid;
    String appid;
    String sposid;
    String aposid;
    String dspid;

    String pdRtbStrategy;
    String day;
    String hour;
    String mediaMasterName;
    String mediaMasterId;
    String mediaName;
    String appName;
    String posName;
    String adx_pos_name;
    String dspName;
    Long itime;
    String windowEndTime;
    String orderId;
    String orderName;

    Long bidReqNum;
    Long bidRespNum;
    Long parseFillNum;
    Long successNum;
    Long expNum;
    Long clickNum;
    Long hoistNum;
    Double income;
    Double cost;
    Long reqTime;
    //买方广告位id
    private String posId = "";
    //预算分组
    String budgetType;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPubid() {
        return pubid;
    }

    public void setPubid(String pubid) {
        this.pubid = pubid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSposid() {
        return sposid;
    }

    public void setSposid(String sposid) {
        this.sposid = sposid;
    }

    public String getAposid() {
        return aposid;
    }

    public void setAposid(String aposid) {
        this.aposid = aposid;
    }

    public String getDspid() {
        return dspid;
    }

    public void setDspid(String dspid) {
        this.dspid = dspid;
    }

    public String getPdRtbStrategy() {
        return pdRtbStrategy;
    }

    public void setPdRtbStrategy(String pdRtbStrategy) {
        this.pdRtbStrategy = pdRtbStrategy;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMediaMasterName() {
        return mediaMasterName;
    }

    public void setMediaMasterName(String mediaMasterName) {
        this.mediaMasterName = mediaMasterName;
    }

    public String getMediaMasterId() {
        return mediaMasterId;
    }

    public void setMediaMasterId(String mediaMasterId) {
        this.mediaMasterId = mediaMasterId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getAdx_pos_name() {
        return adx_pos_name;
    }

    public void setAdx_pos_name(String adx_pos_name) {
        this.adx_pos_name = adx_pos_name;
    }

    public String getDspName() {
        return dspName;
    }

    public void setDspName(String dspName) {
        this.dspName = dspName;
    }

    public Long getItime() {
        return itime;
    }

    public void setItime(Long itime) {
        this.itime = itime;
    }

    public String getWindowEndTime() {
        return windowEndTime;
    }

    public void setWindowEndTime(String windowEndTime) {
        this.windowEndTime = windowEndTime;
    }

    public Long getBidReqNum() {
        return bidReqNum;
    }

    public void setBidReqNum(Long bidReqNum) {
        this.bidReqNum = bidReqNum;
    }

    public Long getBidRespNum() {
        return bidRespNum;
    }

    public void setBidRespNum(Long bidRespNum) {
        this.bidRespNum = bidRespNum;
    }

    public Long getParseFillNum() {
        return parseFillNum;
    }

    public void setParseFillNum(Long parseFillNum) {
        this.parseFillNum = parseFillNum;
    }

    public Long getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Long successNum) {
        this.successNum = successNum;
    }

    public Long getExpNum() {
        return expNum;
    }

    public void setExpNum(Long expNum) {
        this.expNum = expNum;
    }

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    public Long getHoistNum() {
        return hoistNum;
    }

    public void setHoistNum(Long hoistNum) {
        this.hoistNum = hoistNum;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

    public static void main(String[] args) {
        String str = "{\"cost\":0.0,\"day\":\"2022-09-08\",\"dealid\":\"2022080918510183\",\"dspid\":\"988801\",\"dtime\":\"0\",\"expNum\":0,\"fillNum\":0,\"hoistNum\":0,\"hour\":\"14\",\"income\":0.0,\"itime\":1662617553372,\"orderId\":\"2022080918510183\",\"parseFillNum\":0,\"pdRtbStrategy\":\"pd\",\"reqNum\":0,\"reqTime\":0,\"requestid\":\"35e68f9fe628407ab537e597f578cb1d\",\"respNum\":0,\"sposid\":\"30000132\",\"successNum\":0,\"sysid\":\"2\",\"posId\":\"3333333\",\"ecode\":\"0\",\"tlds\":\"\",\"androidIdMd5\":\"c413b597b9ce4b71e876a62845247449\",\"maxduration\":15,\"province\":\"北京省\",\"stage\":\"3\",\"chargingWay\":\"0\",\"materid\":\"\",\"packageName\":\"ww\",\"dptop\":\"\",\"status\":\"0\"}";

        AggregateWithDsp aggregateWithDsp = JSONObject.parseObject(str, AggregateWithDsp.class);

    }
}