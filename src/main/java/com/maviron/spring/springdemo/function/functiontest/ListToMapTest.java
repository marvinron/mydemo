package com.maviron.spring.springdemo.function.functiontest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToLongFunction;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ListToMapTest.java
 * @Description TODO
 * @createTime 2022年04月22日 15:41:00
 */
public class ListToMapTest {

    public static <T,R> Map<T,R> listToMap(List<T> list,Function<T, R> function){
        Map<T,R> map = new HashMap<>();
        for(T t : list){
            map.put(t, function.apply(t));
        }
        return map;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("32");
            add("312");
            add("322");
            add("3253");
        }};
        Function<String,Integer> function =str->str.length();
        ToLongFunction<Long> longFunction = Long::longValue;
        Map<String, Integer> stringIntegerMap = listToMap(list, function);
        System.out.println(stringIntegerMap);
        Duration duration = Duration.ofDays(3);

        System.out.println(duration);
    }
}
