package com.maviron.spring.springdemo.serialize;

import java.util.Map;

/**
 * 查询需要缓存信息的接口
 */
public interface MappingSearchService {
    Map<String, Map<String,String>> queryMapping();
}
