package com.maviron.spring.springdemo.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
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
import java.math.RoundingMode;
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
        // boolean equals = Objects.equals(null, null);
        // boolean equals1 = org.apache.commons.lang3.StringUtils.equals(null, "123");
        // System.out.println(equals1);
        //
        // boolean b = org.springframework.util.ObjectUtils.nullSafeEquals(null, null);
        // System.out.println(b);
        // String[] strings = StringUtils.tokenizeToStringArray("1,2,43,5,6,3", ",");
        //
        // String dquote = Strings.dquote("1,2,4,6");
        // System.out.println(dquote);
        // String quote = Strings.quote("1235,32,435,21");
        // System.out.println(quote);
        // String string = Objects.toString(null, "-1");
        // System.out.println(string);
        String str = "{\"1\":{\"min\":1.66,\"max\":2.50}}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject jsonObject1 = jsonObject.getJSONObject("1");
        Double min = jsonObject1.getDouble("min");
        // System.out.println(min);
        Double max = jsonObject1.getDouble("max");
        // System.out.println(max);
        // System.out.println(aDouble);
        for (int i = 0; i < 1000; i++) {
            double v = RandomUtil.randomDouble(min, max, 2, RoundingMode.HALF_DOWN);
            if (v == 1.66) {
                System.out.println(v);
            }
        }

        // for (int i = 0; i < 1000; i++) {
        //     int v = RandomUtil.randomInt(166, 251);
        //     double d = v/100;
        //     System.out.println(d);
        // }

    }
}
