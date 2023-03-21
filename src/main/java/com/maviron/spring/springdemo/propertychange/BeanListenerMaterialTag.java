package com.maviron.spring.springdemo.propertychange;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BeanListenerMaterialTag.java
 * @Description TODO
 * @createTime 2023年03月20日 11:15:00
 */
public class BeanListenerMaterialTag implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(MaterialTag.NAME))
            System.out.println("BeanTest 的 name 属性变化！");
    }
}
