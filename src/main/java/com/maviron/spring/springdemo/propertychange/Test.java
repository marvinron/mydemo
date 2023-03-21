package com.maviron.spring.springdemo.propertychange;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年03月20日 11:19:00
 */
public class Test {
    public static void main(String[] args) {
        MaterialTag material = new MaterialTag();
        material.addPropertyChangeListener(new BeanListenerMaterialTag());
        material.setName("123");
        material.setName("123");
        System.out.println(material.getName());
    }
}
