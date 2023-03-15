package com.maviron.spring.springdemo.until;

import cn.hutool.core.map.MapUtil;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * @author poker.li
 * @date 2021/9/30 15:53
 * <p>
 * Bean Map工具类
 */
public class BeanMapUtils {

    public static Map<String, Object> beanToMap(Object bean) {
        //noinspection unchecked
        return (Map<String, Object>) BeanMap.create(bean);
    }


}
