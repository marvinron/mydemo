package com.maviron.spring.springdemo.test;

import cn.hutool.core.date.StopWatch;
import com.maviron.spring.springdemo.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EntityUtilsTest.java
 * @Description TODO
 * @createTime 2024年07月15日 18:46:00
 */
public class EntityUtilsTest {
    public static void main(String[] args) {

        User entityA = new User();
        entityA.setAge(null);
        entityA.setName("adas");

        User entityB = new User();
        entityB.setEmail("asdsa");
        entityB.setSalery(12D);
        entityB.setName("asdsa213213");
        // getNullPropertyNames(entityA);
        BeanUtils.copyProperties(entityB, entityA, getNullPropertyNames(entityA));
        System.out.println("==========");
    }


    /**
     * 获取需要忽略的属性
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            // 此处判断可根据需求修改
            if (!Objects.isNull(srcValue)) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
