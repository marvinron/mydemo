package com.maviron.spring.springdemo.beanequals;

import com.maviron.spring.springdemo.thread.EntityTest;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 工具类：比较两个对象并获取其中不相等的字段
 */
public abstract class AbstractContrast {
    /**
     * 比较两个对象属性o1和o2是否相等 相等返回true(子类根据实际情况重写对比方法)
     *
     * @param o1
     * @param o2
     * @return
     */
    protected static boolean isEquals(Object o1, Object o2) {
        return Objects.deepEquals(o1, o2);
    }

    /**
     * 比较两个对象并获取其中不相等的字段
     *
     * @param obj1 对象1
     * @param obj2 对象2
     * @return Map key:属性名 value:[对象1的属性值,对象2的属性值]
     */
    public static Map<String, List<Object>> compareFields(Object obj1, Object obj2) {
        return compareFields(obj1, obj2, null, null);
    }

    /**
     * 比较两个对象并获取其中不相等的字段(设置对比过程包含的属性)
     *
     * @param obj1       对象1
     * @param obj2       对象2
     * @param includeArr 对比包含的属性
     * @return Map key:属性名 value:[对象1的属性值,对象2的属性值]
     */
    public Map<String, List<Object>> compareFieldsIncludeProp(Object obj1, Object obj2, String[] includeArr) {
        return compareFields(obj1, obj2, includeArr, null);
    }

    /**
     * 比较两个对象并获取其中不相等的字段(设置对比过程忽略的属性)
     *
     * @param obj1      对象1
     * @param obj2      对象2
     * @param ignoreArr 忽略对比的属性
     * @return Map key:属性名 value:[对象1的属性值,对象2的属性值]
     */
    public Map<String, List<Object>> compareFieldsIgnoreProp(Object obj1, Object obj2, String[] ignoreArr) {
        return compareFields(obj1, obj2, null, ignoreArr);
    }

    /**
     * 比较两个对象并获取其中不相等的字段
     *
     * @param obj1       对象1
     * @param obj2       对象2
     * @param includeArr 对比包含的属性
     * @param ignoreArr  忽略对比的属性
     * @return Map key:属性名 value:[对象1的属性值,对象2的属性值]
     */
    private static Map<String, List<Object>> compareFields(Object obj1, Object obj2, String[] includeArr, String[] ignoreArr) {
        try {
            Map<String, List<Object>> map = new HashMap<>(16);
            //只有两个对象都是同一类型才有可比性
            if (obj1.getClass() != obj2.getClass()) {
                return map;
            }
            List<String> includeArrList = null;
            List<String> ignoreList = null;
            if (includeArr != null && includeArr.length > 0) {
                includeArrList = Arrays.asList(includeArr);
            }
            if (ignoreArr != null && ignoreArr.length > 0) {
                ignoreList = Arrays.asList(ignoreArr);
            }
            Class clazz = obj1.getClass();
            //获取object的属性名称
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                String propName = pd.getName();
                //如果该属性不属于对比包含的属性或者属于忽略对比的属性就跳过该属性对比
                if ((includeArrList != null && !includeArrList.contains(propName)) ||
                        (ignoreList != null && ignoreList.contains(propName))) {
                    continue;
                }
                //获取属性的get方法
                Method readMethod = pd.getReadMethod();
                //在obj1、obj2上调用get方法等同于获得obj1、obj2的属性值
                Object o1 = readMethod.invoke(obj1);
                Object o2 = readMethod.invoke(obj2);
                //如果不相等放入Map
                if (!isEquals(o1, o2)) {
                    map.put(propName, Arrays.asList(o1, o2));
                }
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException("比对过程中发生异常", e);
        }
    }

    public static void main(String[] args) {
        EntityTest entity = new EntityTest();
        entity.setId(1);
        entity.setMoney(1.0);
        entity.setRate(2.0);

        EntityTest entity1 = new EntityTest();
        entity1.setId(1);
        entity1.setMoney(1.0);
        entity1.setRate(2.0);
        Map<String, List<Object>> stringListMap = compareFields(entity, entity1);
        System.out.println(stringListMap);
    }
}
