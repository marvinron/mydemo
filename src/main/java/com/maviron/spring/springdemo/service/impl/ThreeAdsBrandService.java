package com.maviron.spring.springdemo.service.impl;

import com.maviron.spring.springdemo.entity.AdsBrand;
import com.maviron.spring.springdemo.service.AdsBrandService;
import org.springframework.stereotype.Service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OneAdsBrandService.java
 * @Description TODO
 * @createTime 2023年02月03日 16:08:00
 */
@Service("three")
public class ThreeAdsBrandService implements AdsBrandService {
    @Override
    public AdsBrand queryById(Integer id) {
        return null;
    }

    @Override
    public AdsBrand test(Integer id) {
        return new AdsBrand();
    }
}
