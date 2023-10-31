package com.maviron.spring.springdemo.demo.abstractdemo;

import com.maviron.spring.springdemo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Provider.java
 * @Description TODO
 * @createTime 2021年11月23日 14:08:00
 */
public class Provider extends AbstractProvider {
    //获取请求
    public void get(String key) {
        executeCommand(key, () -> System.out.println("执行了获取key的指令" + key), null);
    }
    //判断key是否存在
    public void exists(final String key){
        executeCommand(key, () -> System.out.println("执行了判断是否存在的指令"+key),null);
    }

    @Test
    public void test() {
        get("wwww");
    }
    public static void main(String[] args) {
        User user = new User();
       String str = "http://www.baidu.com";
        user.setName(str);
        StringBuilder sb = new StringBuilder(user.getName());
        sb.append("=====");
        System.out.println(user.getName());

    }
}
