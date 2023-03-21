package com.maviron.spring.springdemo.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class EmployeeDynamicSqlSupport {
  public static final DmpTestSqlTable dmpTest = new DmpTestSqlTable();
  public static final SqlColumn<String> appName = dmpTest.appName;
  public static final SqlColumn<String> packageName = dmpTest.packageName;

  public static final class DmpTestSqlTable extends SqlTable {
    public final SqlColumn<String> appName = column("app_name", JDBCType.VARCHAR);
    public final SqlColumn<String> packageName = column("package_name", JDBCType.VARCHAR);
    public DmpTestSqlTable() {
       super("dmp_test");
    }
  }
}