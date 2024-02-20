package com.maviron.spring.springdemo.serialize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(using = BeanNameMappingSerializer.class)
public class DmpGrabPosParamMapping implements Serializable {
    /**
     * 媒体主账号
     */
    @JsonIgnore
    private String accountNo;

    /**
     * 媒体主名称
     */
    private String accountName;

    /**
     * 媒体广告位名称
     */
    private String mediaPosName;

    private String requestid;

    private String mediaprice;

    private String platform;

    private String sposid;

    private String userTag;

    private String posWidth;

    private String posHeight;

    private String minduration;

    private String maxduration;

    private String appid;

    private String appName;

    private String ver;

    private String packageName;

    private String storeurl;

    private String cat;

    private String appstoreversion;

    private String hmsversion;

    private String publishName;

    private String ua;

    private String ip;

    private String devicetype;

    private String os;

    private String osv;

    private String dpi;

    private String ppi;

    private String density;

    private String orientation;

    private String deviceWidth;

    private String deviceHeight;

    private String carrier;

    private String connectiontype;

    private String idfa;

    private String idfv;

    private String imei;

    private String imeiMd5;

    private String androidid;

    private String androidIdMd5;

    private String mac;

    private String macmd5;

    private String make;

    private String model;

    private String bootMark;

    private String updateMark;

    private String boottime;

    private String osupdatetime;

    private String deviceName;

    private String deviceNameMd5;

    private String memory;

    private String hardDisk;

    private String timezone;

    private String caid;

    private String caidver;

    private String aaid;

    private String startuptime;

    private String birthtime;

    private String paid;

    private String lat;

    private String lon;

    private String brand;

    private String oaid;

    private String oaidMd5;

    private String ipv6;

    private String cookieid;

    private String tempid;

    private String mapps;

    private String idfaMd5;

    private String sdkver;

    private String appInteractionType;

    private static final long serialVersionUID = 1L;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMediaPosName() {
        return mediaPosName;
    }

    public void setMediaPosName(String mediaPosName) {
        this.mediaPosName = mediaPosName;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getMediaprice() {
        return mediaprice;
    }

    public void setMediaprice(String mediaprice) {
        this.mediaprice = mediaprice;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSposid() {
        return sposid;
    }

    public void setSposid(String sposid) {
        this.sposid = sposid;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
    }

    public String getPosWidth() {
        return posWidth;
    }

    public void setPosWidth(String posWidth) {
        this.posWidth = posWidth;
    }

    public String getPosHeight() {
        return posHeight;
    }

    public void setPosHeight(String posHeight) {
        this.posHeight = posHeight;
    }

    public String getMinduration() {
        return minduration;
    }

    public void setMinduration(String minduration) {
        this.minduration = minduration;
    }

    public String getMaxduration() {
        return maxduration;
    }

    public void setMaxduration(String maxduration) {
        this.maxduration = maxduration;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getStoreurl() {
        return storeurl;
    }

    public void setStoreurl(String storeurl) {
        this.storeurl = storeurl;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getAppstoreversion() {
        return appstoreversion;
    }

    public void setAppstoreversion(String appstoreversion) {
        this.appstoreversion = appstoreversion;
    }

    public String getHmsversion() {
        return hmsversion;
    }

    public void setHmsversion(String hmsversion) {
        this.hmsversion = hmsversion;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsv() {
        return osv;
    }

    public void setOsv(String osv) {
        this.osv = osv;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getPpi() {
        return ppi;
    }

    public void setPpi(String ppi) {
        this.ppi = ppi;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getDeviceWidth() {
        return deviceWidth;
    }

    public void setDeviceWidth(String deviceWidth) {
        this.deviceWidth = deviceWidth;
    }

    public String getDeviceHeight() {
        return deviceHeight;
    }

    public void setDeviceHeight(String deviceHeight) {
        this.deviceHeight = deviceHeight;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getConnectiontype() {
        return connectiontype;
    }

    public void setConnectiontype(String connectiontype) {
        this.connectiontype = connectiontype;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImeiMd5() {
        return imeiMd5;
    }

    public void setImeiMd5(String imeiMd5) {
        this.imeiMd5 = imeiMd5;
    }

    public String getAndroidid() {
        return androidid;
    }

    public void setAndroidid(String androidid) {
        this.androidid = androidid;
    }

    public String getAndroidIdMd5() {
        return androidIdMd5;
    }

    public void setAndroidIdMd5(String androidIdMd5) {
        this.androidIdMd5 = androidIdMd5;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMacmd5() {
        return macmd5;
    }

    public void setMacmd5(String macmd5) {
        this.macmd5 = macmd5;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBootMark() {
        return bootMark;
    }

    public void setBootMark(String bootMark) {
        this.bootMark = bootMark;
    }

    public String getUpdateMark() {
        return updateMark;
    }

    public void setUpdateMark(String updateMark) {
        this.updateMark = updateMark;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNameMd5() {
        return deviceNameMd5;
    }

    public void setDeviceNameMd5(String deviceNameMd5) {
        this.deviceNameMd5 = deviceNameMd5;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid;
    }

    public String getCaidver() {
        return caidver;
    }

    public void setCaidver(String caidver) {
        this.caidver = caidver;
    }

    public String getAaid() {
        return aaid;
    }

    public void setAaid(String aaid) {
        this.aaid = aaid;
    }

    public String getStartuptime() {
        return startuptime;
    }

    public void setStartuptime(String startuptime) {
        this.startuptime = startuptime;
    }

    public String getBirthtime() {
        return birthtime;
    }

    public void setBirthtime(String birthtime) {
        this.birthtime = birthtime;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOaid() {
        return oaid;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }

    public String getOaidMd5() {
        return oaidMd5;
    }

    public void setOaidMd5(String oaidMd5) {
        this.oaidMd5 = oaidMd5;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getCookieid() {
        return cookieid;
    }

    public void setCookieid(String cookieid) {
        this.cookieid = cookieid;
    }

    public String getTempid() {
        return tempid;
    }

    public void setTempid(String tempid) {
        this.tempid = tempid;
    }

    public String getMapps() {
        return mapps;
    }

    public void setMapps(String mapps) {
        this.mapps = mapps;
    }

    public String getIdfaMd5() {
        return idfaMd5;
    }

    public void setIdfaMd5(String idfaMd5) {
        this.idfaMd5 = idfaMd5;
    }

    public String getSdkver() {
        return sdkver;
    }

    public void setSdkver(String sdkver) {
        this.sdkver = sdkver;
    }

    public String getAppInteractionType() {
        return appInteractionType;
    }

    public void setAppInteractionType(String appInteractionType) {
        this.appInteractionType = appInteractionType;
    }
}