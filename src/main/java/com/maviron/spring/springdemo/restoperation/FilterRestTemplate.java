package com.maviron.spring.springdemo.restoperation;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName FilterRestTemplate.java
 * @Description TODO
 * @createTime 2023年07月28日 16:55:00
 */
public abstract class FilterRestTemplate implements RestOperations {
    protected volatile RestTemplate restTemplate;
    protected FilterRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

}
