package com.maviron.spring.springdemo.function.truefalsehandle;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName VUtils.java
 * @Description TODO
 * @createTime 2022年04月15日 10:57:00
 */
public class VUtils {
    public static ThrowExceptionFunction isTure(boolean b) {

        return (errorMessage) -> {
            if (b) {
                throw new RuntimeException(errorMessage);
            }
        };
    }

    public static void main(String[] args) {
        ThrowExceptionFunction ture = VUtils.isTure(true);
        System.out.println(ture);
    }
}
