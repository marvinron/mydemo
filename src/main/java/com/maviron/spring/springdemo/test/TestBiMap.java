package com.maviron.spring.springdemo.test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestBiMap.java
 * @Description TODO
 * @createTime 2023年02月27日 10:52:00
 */
public class TestBiMap {
    public static void main(String[] args) {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("Hydra","Programmer");
        biMap.put("Tony","IronMan");
        biMap.put("Thanos","Titan");
        System.out.println(biMap);
        BiMap<String, String> inverse = biMap.inverse();
        inverse.put("IronMan","Stark");
        System.out.println(inverse);
        System.out.println(biMap);

    }
}
