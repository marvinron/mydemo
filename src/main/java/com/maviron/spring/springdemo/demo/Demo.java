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
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        List<String> list = new ArrayList<>(map.keySet());
        Collections.shuffle(list);
        String s = list.get(0);
        System.out.println(s);

    }

}
