package com.maviron.spring.springdemo.importdesc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ConfigA.java
 * @Description TODO
 * @createTime 2022年08月11日 10:10:00
 */
//@Import(ConfigB.class)
//@Import(ServiceImportSelector.class)
//@Configuration
public class ConfigA {
    //@Bean
    //@ConditionalOnMissingBean
    public ServiceInterface serviceA(){
        return new ServiceA();
    }
}
