package com.maviron.spring.springdemo.springstatemachine.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * ads订单表(AdsOrderBak)实体类
 *
 * @author makejava
 * @since 2024-02-19 15:44:45
 */
public class AdsOrderBak implements Serializable {
    private static final long serialVersionUID = -31331840502415059L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 订单名称
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 删除标记，0未删除  1已删除
     */
    private Integer deleteFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createUserCode;
    /**
     * 更新人
     */
    private String updateUserCode;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
