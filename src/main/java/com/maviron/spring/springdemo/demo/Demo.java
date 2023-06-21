package com.maviron.spring.springdemo.demo;


import com.google.common.collect.Sets;
import com.maviron.spring.springdemo.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.jasypt.encryption.StringEncryptor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        //LocalDateTime now = LocalDateTime.now();
        //System.out.println(now);
        //BigDecimal bigDecimal = BigDecimal.valueOf(12L);
        //System.out.println(bigDecimal);
        //String string = "a|b|c|d";
        //String[] split = string.split("|");
        //Arrays.stream(split).forEach(System.out::println);
        //Map<String,String> map = new HashMap<>();
        //map.put("a","1");
        //map.put("b","2");
        //map.put("c","3");
        //List<String> list = new ArrayList<>(map.keySet());
        //Collections.shuffle(list);
        //String s = list.get(0);
        //System.out.println(s);
        int i = compareVersion("2.0.4.1.2", "2.0.4.1.1");
        if (i > 0) {
            System.out.println("左边大");
        } else if (i < 0) {
            System.out.println("右边大");
        } else {
            System.out.println("相等");
        }
    }

    /**
     * 版本号比较
     *
     * @param v1
     * @param v2
     * @return 0代表相等，1代表左边大，-1代表右边大
     * Utils.compareVersion("1.0.358_20180820090554","1.0.358_20180820090553")=1
     */
    public static int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._]");
        String[] version2Array = v2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

}
