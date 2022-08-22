package com.maviron.spring.springdemo.normalarithmetic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Servers.java
 * @Description TODO
 * @createTime 2022年08月15日 11:56:00
 */
public class Servers {
    public static Map<String, Integer> WEIGHT_SERVERS = new LinkedHashMap<>();
    static {
        // 权重值设置的略微小一点，方便后续理解算法
        WEIGHT_SERVERS.put("44.120.110.001:8080",3);
        WEIGHT_SERVERS.put("44.120.110.002:8081",2);
        WEIGHT_SERVERS.put("44.120.110.003:8082",1);
    }

}
