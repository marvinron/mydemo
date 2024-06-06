package com.maviron.spring.springdemo.test;

import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyYmalTest.java
 * @Description TODO
 * @createTime 2024年05月30日 15:54:00
 */
public class MyYmalTest {
    public static void main(String[] args) {
        Map<String,String> string = (Map)ConfigUtil.getenv();
        System.out.println(string);
    }
}
