package com.maviron.spring.springdemo.propertychange;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MaterialTag.java
 * @Description TODO
 * @createTime 2023年03月20日 11:12:00
 */

public class MaterialTag extends PropertyChangeSupportMaterialTag{

    public static final String NAME = "name";
    private String name = "";
    public void setName(String name) {
        if (this.name.equals(name)) {
            System.out.println("BeanTest 的 name 属性没有变化！");
            return;
        }
        this.name = name;
        firePropertyChange(NAME, null, name);
    }

    public String getName() {
        return this.name;
    }
}
