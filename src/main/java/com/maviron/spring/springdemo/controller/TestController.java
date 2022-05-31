package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.demo.annotation.SystemCrmlog;
import com.maviron.spring.springdemo.demo.config.SystemLogAspect;
import com.maviron.spring.springdemo.demo.web.ClassUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description TODO
 * @createTime 2021年12月21日 11:24:00
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("annotation")
    public String getAnnotation() throws NoSuchMethodException {
        Method[] declaredMethods = SystemLogAspect.class.getDeclaredMethods();

        Method method = SystemLogAspect.class.getDeclaredMethod("crmAspect", null);
        Pointcut annotation = ClassUtil.getAnnotation(method, Pointcut.class);
        return annotation.value();
    }

    public static void main(String[] args) {
        boolean equals = Objects.equals(null, null);
        boolean equals1 = org.apache.commons.lang3.StringUtils.equals(null, "123");
        System.out.println(equals1);

        boolean b = org.springframework.util.ObjectUtils.nullSafeEquals(null, null);
        System.out.println(b);
        StringUtils.tokenizeToStringArray("1,2,43,5,6,3", ",");
        String dquote = Strings.dquote("1,2,4,6");
        System.out.println(dquote);
        String quote = Strings.quote("1235,32,435,21");
        System.out.println(quote);
        String string = Objects.toString(null, "-1");
        System.out.println(string);

    }
}
