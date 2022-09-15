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

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdsBrand> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adsBrand 实例对象
     * @return 实例对象
     */
    AdsBrand insert(AdsBrand adsBrand);

    /**
     * 修改数据
     *
     * @param adsBrand 实例对象
     * @return 实例对象
     */
    AdsBrand update(AdsBrand adsBrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    AdsBrand test(Integer id);

}
