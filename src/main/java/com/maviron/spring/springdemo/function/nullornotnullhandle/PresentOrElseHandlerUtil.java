package com.maviron.spring.springdemo.function.nullornotnullhandle;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PresentOrElseHandlerUtil.java
 * @Description 判断是否存在的分支工具处理类
 * @createTime 2022年04月15日 12:33:00
 */
public class PresentOrElseHandlerUtil {
    public static  PresentOrElseHandler<?> isBlankOrNoBlank(String str){
        return (consumer,runnable)->{
            if(StringUtils.isBlank(str)){
                runnable.run();
            }else {
                consumer.accept(str);
            }
        };
    }

    public static void main(String[] args) {
        PresentOrElseHandlerUtil.isBlankOrNoBlank(null).presentOrElseHandle(doNotBlankAction("123"), doBlankAction());
    }

    private static Consumer doNotBlankAction(String s) {
        return c -> System.out.println(s);
    }

    private static Runnable doBlankAction() {
        return ()-> System.out.println("输入的参数为空");

    }
}
