package com.maviron.spring.springdemo.sms.constant;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsConstant.java
 * @Description 短信相关的正则校验
 * @createTime 2022年05月11日 18:23:00
 */
public class SmsConstant {

    public static String DEFAULT_PLACE_HOLDER_REGEX = "\\{[a-z].*?\\}";

    public static String DEFAULT_PLACE_HOLDER_KEY_REGEX = "[^(\\{)|(\\})]+";
}
