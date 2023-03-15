package com.maviron.spring.springdemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public class RecipeCalendar{
 
    private static final long serialVersionUID = 1L;
 
    /**
     * 食谱日历 主键
     */
    private Long id;
 
    /**
     * 患者唯一编号
     */
    private Long patientFileId;
 
    /**
     * 租户ID
     */
    private Long tenantId;
 
    /**
     * 员工id
     */
    private Long employeeId;
 
    /**
     * 员工姓名
     */
    private String employeeName;
 
    /**
     * 食谱ID
     */
    private Long recipeId;
 
    /**
     * 日期区间 10.早餐 20.中餐 30.晚餐
     */
    private Integer intervalType;
 
    /**
     * 食谱日历日期 格式 YYYY-MM-DD,范围 1000-01-01/9999-12-31
     */
    private Date recipeDate;
 
    /**
     * 食谱名称
     */
    private String recipeName;
 
    /**
     * 食谱热量(kcal)
     */
    private Integer calories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientFileId() {
        return patientFileId;
    }

    public void setPatientFileId(Long patientFileId) {
        this.patientFileId = patientFileId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getIntervalType() {
        return intervalType;
    }

    public void setIntervalType(Integer intervalType) {
        this.intervalType = intervalType;
    }

    public Date getRecipeDate() {
        return recipeDate;
    }

    public void setRecipeDate(Date recipeDate) {
        this.recipeDate = recipeDate;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}