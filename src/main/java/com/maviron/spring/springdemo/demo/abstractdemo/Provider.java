package com.maviron.spring.springdemo.demo.abstractdemo;

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

    public static void main(String[] args) {
        Provider provider = new Provider();
        provider.get("dddd");
        provider.exists("sssss");
    }
}
