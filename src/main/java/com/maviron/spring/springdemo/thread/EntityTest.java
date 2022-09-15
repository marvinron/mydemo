package com.maviron.spring.springdemo.thread;

import cn.hutool.core.util.BooleanUtil;

import java.io.Serializable;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EntityTest.java
 * @Description TODO
 * @createTime 2022年08月26日 11:23:00
 */
public class EntityTest implements Serializable {
    private static final long serialVersionUID = 573853685917383775L;
    private Integer id;
    private double money;
    private double rate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    //@Override
    //public boolean equals(Object obj) {
    //    if (!(obj instanceof EntityTest)) {
    //        return false;
    //    }
    //    EntityTest entity = (EntityTest) obj;
    //    if (BooleanUtil.and(entity.id == this.id, entity.money == this.money, entity.rate == this.rate)) {
    //        return true;
    //    }
    //    return false;
    //}

    public static void main(String[] args) {
        EntityTest entity = new EntityTest();
        entity.setId(1);
        entity.setMoney(1.0);
        entity.setRate(2.0);

        EntityTest entity1 = new EntityTest();
        entity1.setId(1);
        entity1.setMoney(1.0);
        entity1.setRate(2.0);
        if (entity.equals(entity1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
