package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.dao.DmpTestDao;
import com.maviron.spring.springdemo.dao.EmployeeDynamicSqlSupport;
import com.maviron.spring.springdemo.entity.DmpTest;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.insert.render.BatchInsert;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TableTestController.java
 * @Description 测试环境表的controller
 * @createTime 2023年03月21日 09:52:00
 */
@RestController
@RequestMapping("test")
public class TableTestController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping("insert")
    public void insertDmpTest() {
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            DmpTestDao mapper = session.getMapper(DmpTestDao.class);
            List<DmpTest> records = new ArrayList<DmpTest>(){{
                add(new DmpTest("sange","83级"));
                add(new DmpTest("pangzi","80级"));
                add(new DmpTest("jiaohuang","20"));
            }

            }; // not shown

            BatchInsert<DmpTest> batchInsert = SqlBuilder.insert(records)
                    .into(new EmployeeDynamicSqlSupport.DmpTestSqlTable())
                    .map(EmployeeDynamicSqlSupport.appName).toProperty("appName")
                    .map(EmployeeDynamicSqlSupport.packageName).toProperty("packageName")
                    .build()
                    .render(RenderingStrategy.MYBATIS3);

            batchInsert.insertStatements().stream().forEach(mapper::insert);

            session.commit();
        } finally {
            session.close();
        }
    }
}
