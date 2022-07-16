package com.maviron.spring.springdemo.sublisttable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DateTableShardStrategy.java
 * @Description 表拆分策略接口的实现
 * @createTime 2022年07月15日 16:29:00
 */
public class DateTableShardStrategy implements ITableShardStrategy {

    private static final String DATE_PATTERN = "yyyyMMdd";

    @Override
    public String tableShard(String tableName) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return tableName + "_" + sdf.format(new Date());
    }
}
