package com.maviron.spring.springdemo;

import com.maviron.spring.springdemo.proto.DemoProto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = SpringDemoApplication.class)
public class ApplicationTest {
    // Other declarationscourses
    private static final String COURSE1_URL = "http://127.0.0.1:8080/test/proto";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void whenUsingRestTemplate_thenSucceed() {
        //List<HttpMessageConverter<?>> list = new ArrayList<>();
        //list.add(new ProtobufHttpMessageConverter());
        //restTemplate.setMessageConverters(list);
        //DemoProto.Demo forObject = restTemplate.getForObject(COURSE1_URL, DemoProto.Demo.class);
        //System.out.println(forObject.toString());
    }
}