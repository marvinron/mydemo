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

    }
}
