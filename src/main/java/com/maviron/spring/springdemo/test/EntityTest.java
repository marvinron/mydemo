package com.maviron.spring.springdemo.test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EntityTest.java
 * @Description 测试用的实体类
 * @createTime 2022年10月11日 15:21:00
 */
public class EntityTest implements Serializable {
    private static final long serialVersionUID = 5267145989015295486L;
    /**
     * 日期
     */
    private String dt;
    /**
     * 留存天数
     */
    private String retentionDay;
    /**
     * 留存数量
     */
    private String retentionCount;
    /**
     * 新用户数
     */
    private String newUserCount;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getRetentionDay() {
        return retentionDay;
    }

    public void setRetentionDay(String retentionDay) {
        this.retentionDay = retentionDay;
    }

    public String getRetentionCount() {
        return retentionCount;
    }

    public void setRetentionCount(String retentionCount) {
        this.retentionCount = retentionCount;
    }

    public String getNewUserCount() {
        return newUserCount;
    }

    public void setNewUserCount(String newUserCount) {
        this.newUserCount = newUserCount;
    }
    public int getRetentionIntValue(){
        return Integer.valueOf(retentionCount);
    }

    @Override
    public String toString() {
        return "EntityTest{" +
                "dt='" + dt + '\'' +
                ", retentionDay='" + retentionDay + '\'' +
                ", retentionCount='" + retentionCount + '\'' +
                ", newUserCount='" + newUserCount + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "6", "16", "60", "20");
        Collections.sort(list);
        System.out.println(list);
    }
}
