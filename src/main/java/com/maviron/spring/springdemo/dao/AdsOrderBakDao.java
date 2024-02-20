package com.maviron.spring.springdemo.dao;

import com.maviron.spring.springdemo.springstatemachine.entity.AdsOrderBak;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ads订单表(AdsOrderBak)表数据库访问层
 *
 * @author makejava
 * @since 2024-02-19 15:44:46
 */
// @Mapper
public interface AdsOrderBakDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdsOrderBak queryById(@Param("id") Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdsOrderBak> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adsOrderBak 实例对象
     * @return 对象列表
     */
    List<AdsOrderBak> queryAll(AdsOrderBak adsOrderBak);

    /**
     * 新增数据
     *
     * @param adsOrderBak 实例对象
     * @return 影响行数
     */
    int insert(AdsOrderBak adsOrderBak);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdsOrderBak> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AdsOrderBak> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdsOrderBak> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AdsOrderBak> entities);

    /**
     * 修改数据
     *
     * @param adsOrderBak 实例对象
     * @return 影响行数
     */
    int update(AdsOrderBak adsOrderBak);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

