package com.maviron.spring.springdemo.serialize;

import com.alliance.utils.SpringUtils;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description: 媒体字段映射缓存
 * @author: 闫佳成
 * @date: 2024/1/16 19:23
 * @version: 1.0
 */
public class NameMappingCache {
    private static final LoadingCache<String, Map<String,String>> INSTANCE = CacheBuilder.newBuilder().weakValues()
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Map<String, String>>() {
                @Override
                public Map<String, String> load(String s) throws Exception {
                    return new HashMap<String,String>();
                }
            });

    public static LoadingCache<String, Map<String,String>> getInstance(){
        return INSTANCE;
    }

    public static Map<String,String> getUnchecked(String key){
        return getInstance().getUnchecked(key);
    }

    public static void putAll(Map<String, Map<String,String>> maps){
        getInstance().putAll(maps);
    }

    public static boolean isEmpty(){
        return getInstance().asMap().isEmpty();
    }

    /**
     * 添加媒体主映射缓存
     */
    public static void putMediaMapping(){
        if (!isEmpty()){return;}
        MappingSearchService dmpGrabPosParamMappingService = SpringUtils.getBean("dmpGrabPosParamMappingService");
        Map<String, Map<String, String>> mapping = dmpGrabPosParamMappingService.queryMapping();

        synchronized (INSTANCE){
            if (isEmpty()){
                NameMappingCache.putAll(mapping);
            }
        }
    }

    public static void clearCache(){
        if (isEmpty()){return;}
        synchronized (INSTANCE){
            getInstance().invalidateAll();
        }
    }
}
