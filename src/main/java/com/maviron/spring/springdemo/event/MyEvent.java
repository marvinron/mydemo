package com.maviron.spring.springdemo.event;

import com.maviron.spring.springdemo.entity.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyEvent.java
 * @Description
 * @createTime 2022年04月15日 16:18:00
 * @see org.springframework.context.ApplicationEvent
 */
public class MyEvent extends ApplicationEvent {
    private String args;
    public MyEvent(Object source) {
        super(source);
    }
    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public static void main(String[] args) {
        //String regs="([^\\u4e00-\\u9fa5\\w\\(\\)（）])+?";
        //
        //Pattern pattern=Pattern.compile(regs);
        //
        //String testStr="hhh(!@#$%^&*)!@#$%^&*^&*ha对数据   \n";
        //
        //Matcher matcher=pattern.matcher(testStr);
        //
        //String s = matcher.replaceAll("");
        //System.out.println(s);
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${","}",":",true);
        String value = helper.replacePlaceholders("hello ${text},${msg},${noMatch}", new PropertyPlaceholderHelper.PlaceholderResolver() {
            @Override
            public String resolvePlaceholder(String placeholderName) {
                if(placeholderName.equals("text")){
                    return "world";
                }else if (placeholderName.equals("msg")){
                    return "${lang}";
                }else if (placeholderName.equals("lang")){
                    return "java";
                }
                return null;
            }
        });
        System.out.println(value);
    }
}
