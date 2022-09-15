package com.maviron.spring.springdemo.sublisttable;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TableShardInterceptorConfig.java
 * @Description 分表拦截器
 * @createTime 2022年07月15日 17:06:00
 */
//@Configuration
public class TableShardInterceptorConfig {
    //@Bean
    public TableShardInterceptor TableShardInterceptor() {
        return new TableShardInterceptor();
    }
}
