package com.maviron.spring.springdemo.demo;


import com.maviron.spring.springdemo.entity.User;
import org.jasypt.encryption.StringEncryptor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        BigDecimal bigDecimal = BigDecimal.valueOf(12L);
        System.out.println(bigDecimal);
        String string = "a|b|c|d";
        String[] split = string.split("|");
        Arrays.stream(split).forEach(System.out::println);
    }

}
