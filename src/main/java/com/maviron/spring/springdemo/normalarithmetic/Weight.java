package com.maviron.spring.springdemo.normalarithmetic;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Weight.java
 * @Description TODO
 * @createTime 2022年08月15日 11:57:00
 */
public class Weight {
    // 节点信息
    private String server;
    // 节点权重值
    private Integer weight;
    // 动态权重值
    private Integer currentWeight;
    // 构造方法
    public Weight() {}
    public Weight(String server, Integer weight, Integer currentWeight) {
        this.server = server;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }
    // 封装方法
    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Integer getCurrentWeight() {
        return this.currentWeight;
    }
    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

}
