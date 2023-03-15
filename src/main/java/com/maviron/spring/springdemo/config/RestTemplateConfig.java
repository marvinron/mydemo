package com.maviron.spring.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RestTemplateConfig.java
 * @Description TODO
 * @createTime 2023年02月07日 15:14:00
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new ProtobufHttpMessageConverter());
        return rt;
    }
}
