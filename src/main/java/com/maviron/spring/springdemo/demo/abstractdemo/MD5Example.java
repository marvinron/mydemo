package com.maviron.spring.springdemo.demo.abstractdemo;

import java.math.BigDecimal;

public class MD5Example {
    public static void main(String[] args) {
        //String input = "Hello World";
        //String md5Hash = getMD5Hash(input);
        //String md5Hash16 = get16BitMD5Hash(md5Hash);
        //
        //System.out.println("MD5 Hash (32-bit): " + md5Hash);
        //System.out.println("MD5 Hash (16-bit): " + md5Hash16);
        String string = new BigDecimal(100).add((new BigDecimal(100).multiply(new BigDecimal(0.02)))).setScale(2, BigDecimal.ROUND_DOWN).toString();
        System.out.println(string);
    }

    private static void getMD5Hash(String input) throws Exception {

    }
}
