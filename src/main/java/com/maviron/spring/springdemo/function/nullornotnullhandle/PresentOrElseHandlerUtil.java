package com.maviron.spring.springdemo.function.nullornotnullhandle;

import cn.hutool.core.date.StopWatch;
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
    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str) {
        return (consumer, runnable) -> {
            if (StringUtils.isBlank(str)) {
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            if(StringUtils.isBlank("123")){
                System.out.println("输入的参数为空");
            }else {
                System.out.println("123");
            }
            //PresentOrElseHandlerUtil.isBlankOrNoBlank("123").presentOrElseHandle(doNotBlankAction("123"), doBlankAction());
        }
        stopWatch.stop();
        System.out.println("耗费时长是：" + stopWatch.getTotalTimeMillis());
    }

    private static Consumer doNotBlankAction(String s) {
        return c -> System.out.println(s);
    }

    private static Runnable doBlankAction() {
        return () -> System.out.println("输入的参数为空");

    }
}
