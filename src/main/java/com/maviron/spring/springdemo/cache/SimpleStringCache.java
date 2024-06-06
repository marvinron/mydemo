package com.maviron.spring.springdemo.cache;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleStringCache {
    private final int maxSize;
    private final Map<String, String> cache;

    public SimpleStringCache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new LinkedHashMap<String, String>(maxSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > maxSize;
            }
        };
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public static void main(String[] args) {
        // SimpleStringCache stringCache = new SimpleStringCache(100);
        //
        // stringCache.put("myStringKey", "Hello, Simple Cache!");
        //
        // String retrievedString = stringCache.get("myStringKey");
        // System.out.println("String data retrieved: " + retrievedString);
        // String plan_23asdsa = join("plan_23asdsa", "1231asda", "20240527");
        // System.out.println(plan_23asdsa);
        BigDecimal bigDecimal1 = NumberUtil.div("338.01", "1000").setScale(6, RoundingMode.DOWN);
        System.out.println(bigDecimal1.doubleValue());

    }

    private static String join(String... values){
        String join = StringUtils.join(values, ":");
        return join;
    }
}