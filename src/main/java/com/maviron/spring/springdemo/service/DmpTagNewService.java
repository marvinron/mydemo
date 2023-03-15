package com.maviron.spring.springdemo.service;

import com.maviron.spring.springdemo.entity.DmpTagNew;

import java.util.List;

/**
 * DMP标签（新）(DmpTagNew)表服务接口
 *
 * @author makejava
 * @since 2023-03-07 14:42:53
 */
public interface DmpTagNewService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DmpTagNew queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<DmpTagNew> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dmpTagNew 实例对象
     * @return 实例对象
     */
    DmpTagNew insert(DmpTagNew dmpTagNew);

    /**
     * 修改数据
     *
     * @param dmpTagNew 实例对象
     * @return 实例对象
     */
    DmpTagNew update(DmpTagNew dmpTagNew);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<DmpTagNew> queyyAll();

}
