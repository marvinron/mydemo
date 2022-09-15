package com.maviron.spring.springdemo.beanequals;

import cn.hutool.core.util.NumberUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestLock.java
 * @Description TODO
 * @createTime 2022年08月30日 11:42:00
 */
public class TestLock {
    public static void main(String[] args) {
        String s = NumberUtil.formatPercent(100.02, 2);
        System.out.println(s);
        String join = StringUtils.join("123", s, "=======", "!!!!");
        System.out.println(join);
    }
}
