package com.maviron.spring.springdemo.service;

import com.maviron.spring.springdemo.entity.AdsBrand;

import java.util.List;

/**
 * (AdsBrand)表服务接口
 *
 * @author makejava
 * @since 2022-04-07 10:37:50
 */
public interface AdsBrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdsBrand queryById(Integer id);
    AdsBrand test(Integer id);

}
