package com.maviron.spring.springdemo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
@EnableRedisRepositories
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
     //使用 protobuf 作为消息协议(序列化)
    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
    //// 配置restTeamplete 解析 protobuf（反序列化)
    //@Bean
    //RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
    //    return new RestTemplate(Collections.singletonList(hmc));
    //}


}
