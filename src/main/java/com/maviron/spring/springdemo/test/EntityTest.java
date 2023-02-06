package com.maviron.spring.springdemo.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.io.Serializable;
import java.util.*;

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
        List<EntityTest> list = new ArrayList<>();
        EntityTest entityTest1 = new EntityTest();
        entityTest1.setDt("1");
        entityTest1.setNewUserCount("200");
        entityTest1.setRetentionCount("300");
        EntityTest entityTest2 = new EntityTest();
        entityTest2.setDt("1");
        entityTest2.setNewUserCount("200");
        entityTest2.setRetentionCount("300");
        EntityTest entityTest3 = new EntityTest();
        entityTest3.setDt("1");
        entityTest3.setNewUserCount("200");
        entityTest3.setRetentionCount("300");
        list.add(entityTest1);
        list.add(entityTest2);
        list.add(entityTest3);
        System.out.println(list);
        DateTime truncate = DateUtil.truncate(new Date(), DateField.HOUR);
        System.out.println(truncate);
        Object s = DateUtil.offsetHour(new Date(), -1).hour(true);
        DateTime yyyyMMddHH = DateUtil.parse("2022120712", "yyyyMMddHH");
        String s1 = yyyyMMddHH.toDateStr();
        System.out.println(s1);
        System.out.println(s);
        String dateTime = DateUtil.format(DateUtil.offsetHour(new Date(), -1),"yyyyMMddHH");

        System.out.println(dateTime);

        List<Integer> integers = CollectionUtil.newArrayList(1,2,3,4);
        System.out.println(integers);
        Collections.shuffle(integers);
        System.out.println(integers);
        List<Integer> list1 = CollectionUtil.removeAny(integers, 2);
        System.out.println(list1);
    }
}
