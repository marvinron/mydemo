package com.maviron.spring.springdemo.dao;
import com.maviron.spring.springdemo.entity.AdsBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AdsBrand)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-07 10:37:49
 */
@Mapper
public interface AdsBrandDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdsBrand queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdsBrand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adsBrand 实例对象
     * @return 对象列表
     */
    List<AdsBrand> queryAll(AdsBrand adsBrand);

    /**
     * 新增数据
     *
     * @param adsBrand 实例对象
     * @return 影响行数
     */
    int insert(AdsBrand adsBrand);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdsBrand> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AdsBrand> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdsBrand> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AdsBrand> entities);

    /**
     * 修改数据
     *
     * @param adsBrand 实例对象
     * @return 影响行数
     */
    int update(AdsBrand adsBrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

