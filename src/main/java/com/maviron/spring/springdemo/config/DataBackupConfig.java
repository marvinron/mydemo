package com.maviron.spring.springdemo.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class DataBackupConfig {
 
    @PreDestroy
    public void backData(){
 
        System.out.println("开始备份..."+System.currentTimeMillis());
 
 
        System.out.println("结束备份..."+System.currentTimeMillis());
    }
 
}