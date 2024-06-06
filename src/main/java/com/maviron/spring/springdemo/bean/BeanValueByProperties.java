package com.maviron.spring.springdemo.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BeanValueByProperties.java
 * @Description TODO
 * @createTime 2024年06月06日 14:05:00
 */
public class BeanValueByProperties {
    public static Object getProperty(Object obj, String propertyName) {
        try {
            // 获取Bean的信息
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            // 获取所有属性的描述符
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            // 遍历属性的描述符，找到对应属性的Getter方法
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().equals(propertyName)) {
                    Method getterMethod = propertyDescriptor.getReadMethod();
                    // 调用Getter方法获取属性值
                    return getterMethod.invoke(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
