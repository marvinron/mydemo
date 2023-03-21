package com.maviron.spring.springdemo.dao;

import com.maviron.spring.springdemo.entity.DmpTest;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

/**
 * 媒体应用包名(DmpTest)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-21 10:13:44
 */
@Mapper
public interface DmpTestDao {

    /**
     * 新增数据
     *
     * @return 影响行数
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<DmpTest> insertStatement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DmpTest> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DmpTest> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DmpTest> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<DmpTest> entities);

    default int insert(DmpTest dmpTest) {
        return insert(SqlBuilder.insert(dmpTest)
                .into(new EmployeeDynamicSqlSupport.DmpTestSqlTable())
                .map(EmployeeDynamicSqlSupport.appName).toProperty("appName")
                .map(EmployeeDynamicSqlSupport.packageName).toProperty("package")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }


}

