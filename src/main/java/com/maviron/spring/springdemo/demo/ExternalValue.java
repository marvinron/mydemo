package com.maviron.spring.springdemo.demo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TODO
 *
 * @author shijiaoming
 * @version 1.0.0
 * @since 2023/09/20 18:41
 */
@Data
@ToString
public class ExternalValue implements Serializable {
    //todo 驼峰字段需要添加JsonAlias
    private Integer ecode;
    private Integer stage;
    private Integer status;
    private String tempid;
    private JSONObject dsprtime;
    private BigDecimal dealprice;
    private BigDecimal preprice;
    private BigDecimal offerprice;
    private JSONObject prepricearr;
    private JSONObject offerpricearr;
    private String dspmatarr;
    private JSONObject dealidarr;
    private String country;
    private String province;
    private String city;
    private BigDecimal apreprice;
    @JsonAlias({"packageName", "apppackage"})
    private String packageName;
    private String dptop;
    private String tlds;
    private String materid;
    @JsonAlias({"androidIdMd5"})
    private String androidIdMd5;
    @JsonAlias({"imeiMd5", "imei_md5"})
    private String imeiMd5;
    @JsonAlias({"idfaMd5", "idfa_md5"})
    private String idfaMd5;
    @JsonAlias({"oaidMd5", "oaid_md5"})
    private String oaidMd5;
    @JsonAlias({"chargingWay"})
    private String chargingWay;
    @JsonAlias({"dchargingWay"})
    private String dchargingWay;
    @JsonAlias({"mapps", "installedapplist"})
    private String mapps;
    @JsonAlias({"userTag"})
    private String userTag;
    private String nbt;
    private String dposid;
    private String mpid;
    private String mappid;
    private BigDecimal mediaprice;
    private BigDecimal adxofferprice;
    private Long realtime;
}
