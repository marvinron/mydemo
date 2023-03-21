package com.maviron.spring.springdemo.service;

import com.maviron.spring.springdemo.entity.DmpTest;

import java.util.List;

/**
 * 媒体应用包名(DmpTest)表服务接口
 *
 * @author makejava
 * @since 2023-03-21 10:13:45
 */
public interface DmpTestService {


    /**
     * 新增数据
     *
     * @param dmpTest 实例对象
     * @return 实例对象
     */
    DmpTest insert(DmpTest dmpTest);

}
