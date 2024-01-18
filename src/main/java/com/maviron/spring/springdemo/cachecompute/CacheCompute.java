package com.maviron.spring.springdemo.cachecompute;

import cn.hutool.core.date.StopWatch;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CacheCompute.java
 * @Description TODO
 * @createTime 2024年01月18日 09:35:00
 */
public class CacheCompute {
    public static void main(String[] args) throws InterruptedException {
        Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
        //map.put("A", 1);
        //map.put("B", 2);
        //map.put("C", 3);
        //for (Map.Entry<String, Integer> entry : map.entrySet()) {
        //    entry.setValue(entry.getValue() + 1);
        //}
        //map.computeIfAbsent("A",(key,value) -> value+8);
        //map.forEach((key, value) ->map.compute(key,(k,v)->value+1));
        //map.compute("A",(k,v)->v+1);
        //map.putIfAbsent("A",8);
        //map.computeIfAbsent("A",value -> 9);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10; i++) {
            map.compute("C", (k, v) -> {
                if(Objects.isNull(v)){
                    return new AtomicInteger(1);

                }else {
                    v.getAndIncrement();
                    return v;
                }
            } );
        }
        //CollectionUtil.filterNew()
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(map.toString());
    }
}
