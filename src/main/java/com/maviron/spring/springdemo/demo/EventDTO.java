package com.maviron.spring.springdemo.demo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static com.maviron.spring.springdemo.demo.Config.FLOW;

/**
 * event 对象
 *
 * @author shijiaoming
 * @version 1.0.01
 * @since 2023/09/19 14:12
 */
@Slf4j
@ToString
public class EventDTO implements Serializable {
    private static final long serialVersionUID = -8111889326278057056L;
    private String resolution;
    private String eventRname;
    private String adxSecisionStart;
    private String originalOneId;
    private String adxDecisionStart;
    private String adxDecisionWin;
    private String adxDecisionValidBid;
    private String adxDecisionOther;
    private String latitude;
    private String respType;
    private String adxReqType;
    private String longitude;
    private String userId;
    private String eventHour;
    private String bucketId;
    @JsonAlias({"typename"})
    private String eventName;
    private String eventCname;
    private String sysid;
    private String tposid;
    private String tsdkver;
    private String cookieid;
    private String oaid;
    private boolean oaidIsMD5;
    private String imei;
    private boolean imeiIsMD5;
    private String androidid;
    private boolean androidIdIsMD5;
    private String mac;
    private String mac3;
    private String mac4;
    private String idfa;
    private boolean idfaIsMD5;
    private String make;
    private String brand;
    private String model;
    private String platform;
    private String os;
    @JsonAlias({"osv"})
    private String osVersion;
    @JsonAlias({"user_agent"})
    private String ua;
    private String carrier;
    private String ip;
    private String ipv6;
    private String connectiontype;
    private String ver;
    private String sdkver;
    private String gid;
    private String apptype;
    private Integer spostype;
    private String dspid;
    private String dealid;
    private String crid;
    private String murl;
    private String desc;
    private String ldp;
    private String deeplink;
    private String reqtype;
    private String appid;
    private String sposid;
    @JsonAlias({"crequestid"})
    private String requestid;
    private String restype;
    private String ldptype;
    private Long dtime;
    private String sdkecode;
    private String errmsg;
    private String aposid;
    //    @JsonAlias({"rtbId"})
    private String rtbId;
    private String onetime;
    private String isnew;
    private String idfastatus;
    @JsonAlias({"event_time"})
    private Long itime;
    private String lgid;
    private String cgid;
    private String cltype;
    private String tfcgroup;
    private String cdspid;
    private String caposid;
    private String aecpm;
    private String regioncode;
    @JsonAlias({"headBundle"})
    private String headBundle;
    private String bidingprice;
    private String highprice;
    private String exposeprice;
    private String umid;
    private String lgumid;
    @JsonAlias({"deviceidentifierOaid"})
    private String deviceidentifierOaid;
    @JsonAlias({"deviceidentifierEmulator"})
    private String deviceidentifierEmulator;
    private String rtime;
    private String idfv;
    private String bidingecpm;
    @JsonAlias({"appEvent"})
    private String appEvent;
    @JsonAlias({"installTime"})
    private Long installTime;
    @JsonAlias({"abTestId"})
    private String abTestId;
    @JsonAlias({"abTestType"})
    private String abTestType;
    @JsonAlias({"abTestRatioId"})
    private String abTestRatioId;
    private String adnum;
    private String fptype;
    private String bftype;
    private String productName;
    private BigDecimal amount;
    private Integer typeId;
    private String xmobId;
    private Long firstLevel;
    private Long secondLevel;
    private Long thirdLevel;
    private Long fourthLevel;
    private String adScene;
    private String adCreativeType;
    private String phoneModel;
    private String mediaSourceId;
    private String caid;
    private String seat;
    @JsonAlias({"appName"})
    private String appName;
    @JsonAlias({"adxRtbPrice"})
    private String adxRtbPrice;
    private String boottime;
    private String osupdatetime;
    private String mediaOwnerId;
    private Integer screenHeight;
    private Integer screenWidth;
    private String browser;
    private String browserVersion;
    private String eventDate;
    private String createTime;
    private Integer eventDay;
    private Integer eventWeek;
    private Integer eventMonth;
    private String wifi;
    private String source;
    private String oneidDevice;
    private String bmosvIpua;
    private String bmosvIpuaMD5;
    @JsonProperty("value")
    private ExternalValue externalValue;
    private Integer imeiIllegal = 0;
    private Integer oaidIllegal = 0;
    private Integer idfaIllegal = 0;
    private Integer androididIllegal = 0;


    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setOs(String os) {
        this.os = StringUtils.isBlank(os) ? os : os.toLowerCase();
    }

    public boolean isValidExternalValue() {
        return !Objects.isNull(externalValue)
                && !Objects.isNull(externalValue.getEcode())
                && !Objects.isNull(externalValue.getStage())
                && !Objects.isNull(externalValue.getStatus())
                && (!Objects.isNull(this.itime) && String.valueOf(this.itime).matches("\\d+"));
    }

    public boolean isAdxValidExternalValue() {
        return !Objects.isNull(externalValue)
                && !Objects.isNull(externalValue.getEcode())
                && !Objects.isNull(externalValue.getStage())
                && !Objects.isNull(externalValue.getStatus())
                && (!Objects.isNull(this.itime) && String.valueOf(this.itime).matches("\\d+"))
                && !(Objects.isNull(this.requestid) || this.requestid.isEmpty());
    }

    public boolean isValidDeviceId() {
        return (StringUtils.isNotBlank(this.oaid) || StringUtils.isNotBlank(this.androidid) || StringUtils.isNotBlank(this.imei) || StringUtils.isNotBlank(this.idfa))
                || (StringUtils.isNotBlank(this.ip)
                && StringUtils.isNotBlank(this.brand)
                && StringUtils.isNotBlank(this.model)
                && StringUtils.isNotBlank(this.ua)
                && StringUtils.isNotBlank(this.osVersion));
    }

    public boolean isValidEvent() {
        if (StringUtils.isNotBlank(this.sysid)) {
            switch (sysid) {
                case "2":
                    return isAdxValidExternalValue() && isValidDeviceId() && (StringUtils.isNotBlank(this.sysid) && "2".equals(this.sysid) && !externalValue.getStage().equals(10));
                case "3":
                    return isValidExternalValue() && isValidDeviceId() && (StringUtils.isNotBlank(this.sysid) && "3".equals(this.sysid));
                default:
                    return false;
            }
        } else {
            return false;
        }
    }


    private void flowEventNameProcess() {
        switch (this.externalValue.getStage()) {
            case 1:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_sdk_init";
                    this.eventCname = "聚合SDK开始初始化";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_sdk_init_success";
                    this.eventCname = "聚合SDK初始化成功";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 2) {
                    this.eventName = "flow_sdk_init_failed";
                    this.eventCname = "聚合SDK初始化失败";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_alliance_sdk_init";
                    this.eventCname = "聚合SDK初始化第三方SDK";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_alliance_sdk_init_success";
                    this.eventCname = "聚合SDK初始化第三方SDK成功";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 2) {
                    this.eventName = "flow_alliance_sdk_init_failed";
                    this.eventCname = "聚合SDK初始化第三方SDK失败";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 2 && this.externalValue.getEcode() == 0) {
                    this.eventName = "reporting_applist";
                    this.eventCname = "上报applist";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "1阶段未知_状态码:1" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
//请求阶段break;
            case 2:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_sdk_get_strategy";
                    this.eventCname = "sdk请求策略";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_sdk_get_resp";
                    this.eventCname = "sdk收到后台的响应";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_sdk_resp_strategy_empty";
                    this.eventCname = "sdk收到后台的响应，但是无策略填充";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 2) {
                    this.eventName = "flow_sdk_get_resp_success";
                    this.eventCname = "后台的响应失败";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 3) {
                    this.eventName = "flow_sdk_get_resp_timeout";
                    this.eventCname = "后台的响应超时";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "2阶段未知_状态码:2" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 3:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_app_launch_success";
                    this.eventCname = "应用启动成功";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_app_launch_failure";
                    this.eventCname = "应用启动异常";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "3阶段未知_状态码:3" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 4:
                if (this.externalValue.getStatus() == 0 || this.externalValue.getStatus() == 1) {
                    this.eventName = "flow_ad_request";
                    this.eventCname = "流量请求响应";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 2) {
                    this.eventName = "flow_cache_request";
                    this.eventCname = "预缓存广告流量请求响应";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "4阶段未知_状态码:4" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 5:
                this.eventName = "flow_ready_request";
                this.eventCname = "idready接口调用响应";
                this.eventRname = FLOW;
                break;
//曝光break;
            case 6:
                if (this.externalValue.getStatus() == 0 || this.externalValue.getStatus() == 1) {
                    this.eventName = "flow_sdk_ad_source_request";
                    this.eventCname = "广告请求响应";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 4) {
                    this.eventName = "flow_sdk_bidding_request";
                    this.eventCname = "bidding广告请求响应";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 2) {
                    this.eventName = "flow_ad_cache_request";
                    this.eventCname = "广告请求缓存";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 3) {
                    this.eventName = "flow_preload_ad_cache_success_req";
                    this.eventCname = "预加载广告请求成功缓存";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "6阶段未知_状态码:6" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 7:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_impression_show_try";
                    this.eventCname = "尝试曝光，尝试调用show接口";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_alliance_show_try";
                    this.eventCname = "尝试曝光，尝试调用第三方show接口";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_impression_show_success";
                    this.eventCname = "曝光成功，show接口调用成功";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 2 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_impression_recv_callback";
                    this.eventCname = "曝光成功，收到广告平台回调";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 3 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_exp_fail404";
                    this.eventCname = "曝光失败-素材加载失败404";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 3 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_exp_timeout502";
                    this.eventCname = "曝光失败-素材加载超时502";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 3 && this.externalValue.getEcode() == 2) {
                    this.eventName = "flow_exp_affiliate_advertising_fail";
                    this.eventCname = "曝光失败-联盟广告曝光失败";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 4 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_impression_report_not_found";
                    this.eventCname = "曝光链接上报失败-上报链接404";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 5 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_impression_bidding_show";
                    this.eventCname = "bidding广告源曝光，上报bidding价格";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 7 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_show_cache_ad";
                    this.eventCname = "曝光缓存广告";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "7阶段未知_状态码:7" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 8:
                if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_ad_click";
                    this.eventCname = "点击广告内容";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 1) {
                    this.eventName = "flow_ad_skip";
                    this.eventCname = "点击广告内容";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 2) {
                    this.eventName = "flow_ad_close";
                    this.eventCname = "点击关闭广告";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 1 && this.externalValue.getEcode() == 3) {
                    this.eventName = "flow_ad_mute";
                    this.eventCname = "点击静音按钮";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 2 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_landing_page";
                    this.eventCname = "落地页加载完成";
                    this.eventRname = FLOW;
                } else if (this.externalValue.getStatus() == 3 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_app_download";
                    this.eventCname = "点击广告后下载APP";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "8阶段未知_状态码:8" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 9:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_app_quit";
                    this.eventCname = "点击广告后下载APP";
                    this.eventRname = FLOW;
                }
                break;
            case 10:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_err";
                    this.eventCname = "上报各个阶段出现异常的日志";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "10阶段未知_状态码:10" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 11:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_growth_assistant";
                    this.eventCname = "上报增长助手相关的日志";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "11阶段未知_状态码:11" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            case 12:
                if (this.externalValue.getStatus() == 0 && this.externalValue.getEcode() == 0) {
                    this.eventName = "flow_debug_log";
                    this.eventCname = "debug阶段产生的日志";
                    this.eventRname = FLOW;
                } else {
                    this.eventName = "error";
                    this.eventCname = "12阶段未知_状态码:12" + this.externalValue.getStatus() + this.externalValue.getEcode();
                    this.eventRname = FLOW;
                }
                break;
            default:
                this.eventName = "error";
                this.eventCname = "error";
                this.eventRname = FLOW;
        }
    }

    private void flowReqTypeProcess() {
        StringBuffer sb = new StringBuffer().append(this.externalValue.getStage()).append(this.externalValue.getStatus()).append(this.externalValue.getEcode());
        String sse = sb.toString();
        if (this.externalValue.getStage().equals(4) && !this.externalValue.getStatus().equals(2)) {
            if (this.externalValue.getStatus().equals(0)) this.reqtype = sse;
            else this.respType = sse;
        } else if (this.externalValue.getStage().equals(4) && this.externalValue.getStatus().equals(2)) {
            if (this.externalValue.getStatus().equals(2) && this.externalValue.getEcode().equals(0)) this.reqtype = sse;
            else this.respType = sse;
        } else if (this.externalValue.getStage().equals(5)) {
            if (this.externalValue.getStatus().equals(0)) this.reqtype = sse;
            else this.respType = sse;
        } else if (this.externalValue.getStage().equals(6)) {
            if (this.externalValue.getStatus().equals(0)) this.reqtype = sse;
            else this.respType = sse;
        }
    }

    //    private void bucketIdProcess() {
//        if (StringUtils.isNotBlank(this.requestid)) {
//            int requestidHashCode = requestid.hashCode();
//
//            if (ADX_REQ.equals(this.eventName) && StringUtils.isNotBlank(requestid)) {
//                this.bucketId = ((requestidHashCode < 0 ? -requestidHashCode : requestidHashCode) % ADX_REQ_BUCKCT) + "";
//            } else if (BID_REQ.equals(this.eventName) && StringUtils.isNotBlank(requestid)) {
//                this.bucketId = ((requestidHashCode < 0 ? -requestidHashCode : requestidHashCode) % BID_REQ_BUCKCT) + "";
//            }  else {
//                this.bucketId = "1";
//            }
//        }
//    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getEventRname() {
        return eventRname;
    }

    public void setEventRname(String eventRname) {
        this.eventRname = eventRname;
    }

    public String getAdxSecisionStart() {
        return adxSecisionStart;
    }

    public void setAdxSecisionStart(String adxSecisionStart) {
        this.adxSecisionStart = adxSecisionStart;
    }

    public String getOriginalOneId() {
        return originalOneId;
    }

    public void setOriginalOneId(String originalOneId) {
        this.originalOneId = originalOneId;
    }

    public String getAdxDecisionStart() {
        return adxDecisionStart;
    }

    public void setAdxDecisionStart(String adxDecisionStart) {
        this.adxDecisionStart = adxDecisionStart;
    }

    public String getAdxDecisionWin() {
        return adxDecisionWin;
    }

    public void setAdxDecisionWin(String adxDecisionWin) {
        this.adxDecisionWin = adxDecisionWin;
    }

    public String getAdxDecisionValidBid() {
        return adxDecisionValidBid;
    }

    public void setAdxDecisionValidBid(String adxDecisionValidBid) {
        this.adxDecisionValidBid = adxDecisionValidBid;
    }

    public String getAdxDecisionOther() {
        return adxDecisionOther;
    }

    public void setAdxDecisionOther(String adxDecisionOther) {
        this.adxDecisionOther = adxDecisionOther;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getRespType() {
        return respType;
    }

    public void setRespType(String respType) {
        this.respType = respType;
    }

    public String getAdxReqType() {
        return adxReqType;
    }

    public void setAdxReqType(String adxReqType) {
        this.adxReqType = adxReqType;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventHour() {
        return eventHour;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    public String getBucketId() {
        return bucketId;
    }

    public void setBucketId(String bucketId) {
        this.bucketId = bucketId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventCname() {
        return eventCname;
    }

    public void setEventCname(String eventCname) {
        this.eventCname = eventCname;
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getTposid() {
        return tposid;
    }

    public void setTposid(String tposid) {
        this.tposid = tposid;
    }

    public String getTsdkver() {
        return tsdkver;
    }

    public void setTsdkver(String tsdkver) {
        this.tsdkver = tsdkver;
    }

    public String getCookieid() {
        return cookieid;
    }

    public void setCookieid(String cookieid) {
        this.cookieid = cookieid;
    }

    public String getOaid() {
        return oaid;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }

    public boolean isOaidIsMD5() {
        return oaidIsMD5;
    }

    public void setOaidIsMD5(boolean oaidIsMD5) {
        this.oaidIsMD5 = oaidIsMD5;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public boolean isImeiIsMD5() {
        return imeiIsMD5;
    }

    public void setImeiIsMD5(boolean imeiIsMD5) {
        this.imeiIsMD5 = imeiIsMD5;
    }

    public String getAndroidid() {
        return androidid;
    }

    public void setAndroidid(String androidid) {
        this.androidid = androidid;
    }

    public boolean isAndroidIdIsMD5() {
        return androidIdIsMD5;
    }

    public void setAndroidIdIsMD5(boolean androidIdIsMD5) {
        this.androidIdIsMD5 = androidIdIsMD5;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMac3() {
        return mac3;
    }

    public void setMac3(String mac3) {
        this.mac3 = mac3;
    }

    public String getMac4() {
        return mac4;
    }

    public void setMac4(String mac4) {
        this.mac4 = mac4;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public boolean isIdfaIsMD5() {
        return idfaIsMD5;
    }

    public void setIdfaIsMD5(boolean idfaIsMD5) {
        this.idfaIsMD5 = idfaIsMD5;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOs() {
        return os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getConnectiontype() {
        return connectiontype;
    }

    public void setConnectiontype(String connectiontype) {
        this.connectiontype = connectiontype;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getSdkver() {
        return sdkver;
    }

    public void setSdkver(String sdkver) {
        this.sdkver = sdkver;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public Integer getSpostype() {
        return spostype;
    }

    public void setSpostype(Integer spostype) {
        this.spostype = spostype;
    }

    public String getDspid() {
        return dspid;
    }

    public void setDspid(String dspid) {
        this.dspid = dspid;
    }

    public String getDealid() {
        return dealid;
    }

    public void setDealid(String dealid) {
        this.dealid = dealid;
    }

    public String getCrid() {
        return crid;
    }

    public void setCrid(String crid) {
        this.crid = crid;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLdp() {
        return ldp;
    }

    public void setLdp(String ldp) {
        this.ldp = ldp;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public String getReqtype() {
        return reqtype;
    }

    public void setReqtype(String reqtype) {
        this.reqtype = reqtype;
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

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getLdptype() {
        return ldptype;
    }

    public void setLdptype(String ldptype) {
        this.ldptype = ldptype;
    }

    public Long getDtime() {
        return dtime;
    }

    public void setDtime(Long dtime) {
        this.dtime = dtime;
    }

    public String getSdkecode() {
        return sdkecode;
    }

    public void setSdkecode(String sdkecode) {
        this.sdkecode = sdkecode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAposid() {
        return aposid;
    }

    public void setAposid(String aposid) {
        this.aposid = aposid;
    }

    public String getRtbId() {
        return rtbId;
    }

    public void setRtbId(String rtbId) {
        this.rtbId = rtbId;
    }

    public String getOnetime() {
        return onetime;
    }

    public void setOnetime(String onetime) {
        this.onetime = onetime;
    }

    public String getIsnew() {
        return isnew;
    }

    public void setIsnew(String isnew) {
        this.isnew = isnew;
    }

    public String getIdfastatus() {
        return idfastatus;
    }

    public void setIdfastatus(String idfastatus) {
        this.idfastatus = idfastatus;
    }

    public Long getItime() {
        return itime;
    }

    public void setItime(Long itime) {
        this.itime = itime;
    }

    public String getLgid() {
        return lgid;
    }

    public void setLgid(String lgid) {
        this.lgid = lgid;
    }

    public String getCgid() {
        return cgid;
    }

    public void setCgid(String cgid) {
        this.cgid = cgid;
    }

    public String getCltype() {
        return cltype;
    }

    public void setCltype(String cltype) {
        this.cltype = cltype;
    }

    public String getTfcgroup() {
        return tfcgroup;
    }

    public void setTfcgroup(String tfcgroup) {
        this.tfcgroup = tfcgroup;
    }

    public String getCdspid() {
        return cdspid;
    }

    public void setCdspid(String cdspid) {
        this.cdspid = cdspid;
    }

    public String getCaposid() {
        return caposid;
    }

    public void setCaposid(String caposid) {
        this.caposid = caposid;
    }

    public String getAecpm() {
        return aecpm;
    }

    public void setAecpm(String aecpm) {
        this.aecpm = aecpm;
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getHeadBundle() {
        return headBundle;
    }

    public void setHeadBundle(String headBundle) {
        this.headBundle = headBundle;
    }

    public String getBidingprice() {
        return bidingprice;
    }

    public void setBidingprice(String bidingprice) {
        this.bidingprice = bidingprice;
    }

    public String getHighprice() {
        return highprice;
    }

    public void setHighprice(String highprice) {
        this.highprice = highprice;
    }

    public String getExposeprice() {
        return exposeprice;
    }

    public void setExposeprice(String exposeprice) {
        this.exposeprice = exposeprice;
    }

    public String getUmid() {
        return umid;
    }

    public void setUmid(String umid) {
        this.umid = umid;
    }

    public String getLgumid() {
        return lgumid;
    }

    public void setLgumid(String lgumid) {
        this.lgumid = lgumid;
    }

    public String getDeviceidentifierOaid() {
        return deviceidentifierOaid;
    }

    public void setDeviceidentifierOaid(String deviceidentifierOaid) {
        this.deviceidentifierOaid = deviceidentifierOaid;
    }

    public String getDeviceidentifierEmulator() {
        return deviceidentifierEmulator;
    }

    public void setDeviceidentifierEmulator(String deviceidentifierEmulator) {
        this.deviceidentifierEmulator = deviceidentifierEmulator;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getBidingecpm() {
        return bidingecpm;
    }

    public void setBidingecpm(String bidingecpm) {
        this.bidingecpm = bidingecpm;
    }

    public String getAppEvent() {
        return appEvent;
    }

    public void setAppEvent(String appEvent) {
        this.appEvent = appEvent;
    }

    public Long getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Long installTime) {
        this.installTime = installTime;
    }

    public String getAbTestId() {
        return abTestId;
    }

    public void setAbTestId(String abTestId) {
        this.abTestId = abTestId;
    }

    public String getAbTestType() {
        return abTestType;
    }

    public void setAbTestType(String abTestType) {
        this.abTestType = abTestType;
    }

    public String getAbTestRatioId() {
        return abTestRatioId;
    }

    public void setAbTestRatioId(String abTestRatioId) {
        this.abTestRatioId = abTestRatioId;
    }

    public String getAdnum() {
        return adnum;
    }

    public void setAdnum(String adnum) {
        this.adnum = adnum;
    }

    public String getFptype() {
        return fptype;
    }

    public void setFptype(String fptype) {
        this.fptype = fptype;
    }

    public String getBftype() {
        return bftype;
    }

    public void setBftype(String bftype) {
        this.bftype = bftype;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getXmobId() {
        return xmobId;
    }

    public void setXmobId(String xmobId) {
        this.xmobId = xmobId;
    }

    public Long getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(Long firstLevel) {
        this.firstLevel = firstLevel;
    }

    public Long getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(Long secondLevel) {
        this.secondLevel = secondLevel;
    }

    public Long getThirdLevel() {
        return thirdLevel;
    }

    public void setThirdLevel(Long thirdLevel) {
        this.thirdLevel = thirdLevel;
    }

    public Long getFourthLevel() {
        return fourthLevel;
    }

    public void setFourthLevel(Long fourthLevel) {
        this.fourthLevel = fourthLevel;
    }

    public String getAdScene() {
        return adScene;
    }

    public void setAdScene(String adScene) {
        this.adScene = adScene;
    }

    public String getAdCreativeType() {
        return adCreativeType;
    }

    public void setAdCreativeType(String adCreativeType) {
        this.adCreativeType = adCreativeType;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getMediaSourceId() {
        return mediaSourceId;
    }

    public void setMediaSourceId(String mediaSourceId) {
        this.mediaSourceId = mediaSourceId;
    }

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAdxRtbPrice() {
        return adxRtbPrice;
    }

    public void setAdxRtbPrice(String adxRtbPrice) {
        this.adxRtbPrice = adxRtbPrice;
    }

    public String getBoottime() {
        return boottime;
    }

    public void setBoottime(String boottime) {
        this.boottime = boottime;
    }

    public String getOsupdatetime() {
        return osupdatetime;
    }

    public void setOsupdatetime(String osupdatetime) {
        this.osupdatetime = osupdatetime;
    }

    public String getMediaOwnerId() {
        return mediaOwnerId;
    }

    public void setMediaOwnerId(String mediaOwnerId) {
        this.mediaOwnerId = mediaOwnerId;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getEventDay() {
        return eventDay;
    }

    public void setEventDay(Integer eventDay) {
        this.eventDay = eventDay;
    }

    public Integer getEventWeek() {
        return eventWeek;
    }

    public void setEventWeek(Integer eventWeek) {
        this.eventWeek = eventWeek;
    }

    public Integer getEventMonth() {
        return eventMonth;
    }

    public void setEventMonth(Integer eventMonth) {
        this.eventMonth = eventMonth;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOneidDevice() {
        return oneidDevice;
    }

    public void setOneidDevice(String oneidDevice) {
        this.oneidDevice = oneidDevice;
    }

    public String getBmosvIpua() {
        return bmosvIpua;
    }

    public void setBmosvIpua(String bmosvIpua) {
        this.bmosvIpua = bmosvIpua;
    }

    public String getBmosvIpuaMD5() {
        return bmosvIpuaMD5;
    }

    public void setBmosvIpuaMD5(String bmosvIpuaMD5) {
        this.bmosvIpuaMD5 = bmosvIpuaMD5;
    }

    public ExternalValue getExternalValue() {
        return externalValue;
    }

    public void setExternalValue(ExternalValue externalValue) {
        this.externalValue = externalValue;
    }

    public Integer getImeiIllegal() {
        return imeiIllegal;
    }

    public void setImeiIllegal(Integer imeiIllegal) {
        this.imeiIllegal = imeiIllegal;
    }

    public Integer getOaidIllegal() {
        return oaidIllegal;
    }

    public void setOaidIllegal(Integer oaidIllegal) {
        this.oaidIllegal = oaidIllegal;
    }

    public Integer getIdfaIllegal() {
        return idfaIllegal;
    }

    public void setIdfaIllegal(Integer idfaIllegal) {
        this.idfaIllegal = idfaIllegal;
    }

    public Integer getAndroididIllegal() {
        return androididIllegal;
    }

    public void setAndroididIllegal(Integer androididIllegal) {
        this.androididIllegal = androididIllegal;
    }
}
