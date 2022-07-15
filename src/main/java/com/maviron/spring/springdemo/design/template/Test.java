package com.maviron.spring.springdemo.design.template;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 模板方法的测试类
 * @createTime 2022年07月14日 14:27:00
 */
public class Test {
    public static void main(String[] args) {
        new ResourceUser().execute();
        new ResourceEmployer().execute();
    }
}
