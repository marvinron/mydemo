package com.maviron.spring.springdemo.importdesc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ConfigB.java
 * @Description TODO
 * @createTime 2022年08月11日 10:10:00
 */
//@Configuration
public class ConfigB {
    //@Bean
    //@ConditionalOnMissingBean
    public ServiceInterface serviceB(){
        return new ServiceB();
    }
}
