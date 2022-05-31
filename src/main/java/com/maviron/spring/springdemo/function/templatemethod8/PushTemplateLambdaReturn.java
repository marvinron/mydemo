package com.maviron.spring.springdemo.function.templatemethod8;

import java.util.function.Function;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PushTemplateLambdaReturn.java
 * @Description TODO
 * @createTime 2022年04月25日 09:59:00
 */
public class PushTemplateLambdaReturn {

    public static String get(int cusumerId, String shopName, Function<Object[],String> function){
        System.out.println("配送开始。。。");
        Object[] objects = new Object[]{cusumerId,shopName};
        String apply = function.apply(objects);
        System.out.println("配送结束。。。。。");
        return apply;
    }

    public static Function<Object[],String> getFunction(Object[] objects){
        return new Function<Object[], String>() {

            @Override
            public String apply(Object[] objects) {
                return objects[0]+"===="+objects[1] + "获得了好评";
            }
        };
    }

    public static void main(String[] args) {
        String str = get(1, "水果店", getFunction(new Object[]{
                1, "水果店"
        }));
        System.out.println(str);
    }
}
