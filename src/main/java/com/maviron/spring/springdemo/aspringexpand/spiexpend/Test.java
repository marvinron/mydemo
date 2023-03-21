package com.maviron.spring.springdemo.aspringexpand.spiexpend;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年03月16日 18:09:00
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = SpringFactoriesLoader.loadFactoryNames(MyEnableAutoConfiguration.class, MyEnableAutoConfiguration.class.getClassLoader());
        list.forEach(System.out::println);
    }
}
