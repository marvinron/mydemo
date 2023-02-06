package com.maviron.spring.springdemo.service;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AdsAbBrandService.java
 * @Description
 * @createTime 2023年02月03日 16:20:00
 */
public abstract class AdsAbBrandService<T,R> {
    public abstract T convert(String str);

    public abstract R getResult(String result);
}
