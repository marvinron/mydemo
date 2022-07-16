package com.maviron.spring.springdemo.sublisttable;

/**
 * 表拆分的策略接口
 */
public interface ITableShardStrategy {

    String tableShard(String tableName);

}