package com.maviron.spring.springdemo.function.functionhandleProject;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class HandlerOrElseHandlerUtil {
    public static <T, R> HandleOrElseHandler handleOrElseHandle(T t, Function<T, Boolean> function) {
        T key = null;
        return (f1, f2) -> {
            if (function.apply(t)) {
                return (R) f1.apply(key);
            } else {
                return (R) f2.apply(key);
            }
        };
    }

    public static void main(String[] args) {
        String param = "";
        Function<String, Boolean> judgeOS = osParam -> StringUtils.equalsIgnoreCase(osParam, "Android");
        Boolean amatch = (Boolean) HandlerOrElseHandlerUtil.handleOrElseHandle("android", judgeOS)
                .presentOrElseHandle(doTargetAndroidPersona(param), doTargetIosPersona(param));
        System.out.println(amatch);
    }

    private static Function<String, Boolean> doTargetIosPersona(String param) {
        System.out.println("ios function.....");
        return obj -> StringUtils.equalsIgnoreCase(param, "ios");
    }

    private static Function<String, Boolean> doTargetAndroidPersona(String param) {
        System.out.println("android function.....");
        return obj -> StringUtils.equalsIgnoreCase(param, "android");
    }
}