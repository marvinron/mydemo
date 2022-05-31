package com.maviron.spring.springdemo.function.functionhandle;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PresentOrElseHandlerUtil.java
 * @Description TODO
 * @createTime 2022年04月22日 15:06:00
 */
public class PresentOrElseHandlerUtil {
    public static<T,R> PresentOrElseHandler<T, R> isBlankOrNoBlank(String str) {
        return (f1,f2) -> {
            if (StringUtils.isBlank(str)) {
                return (R)f1.apply((T) str);
            } else {
               return (R)f2.apply((T) str);
            }
        };
    }

    private static<T,R> Function<T,R> doNotBlankAction(String s) {
        return obj-> (R) ("doNotBlankAction "+s);
    }

    private static<T,R> Function<T,R> doBlankAction(String s) {
        return obj -> (R) ("doBlankAction "+s);
    }

    public static void main(String[] args) {
        String o = (String)PresentOrElseHandlerUtil.isBlankOrNoBlank("123").presentOrElseHandle(doNotBlankAction("123"), doBlankAction("123"));
        System.out.println(o);
    }
}
