package com.maviron.spring.springdemo.demo;


import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Sets;
import com.maviron.spring.springdemo.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.jasypt.encryption.StringEncryptor;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        //LocalDateTime now = LocalDateTime.now();
        //System.out.println(now);
        //BigDecimal bigDecimal = BigDecimal.valueOf(12L);
        //System.out.println(bigDecimal);
        //String string = "a|b|c|d";
        //String[] split = string.split("|");
        //Arrays.stream(split).forEach(System.out::println);
        //Map<String,String> map = new HashMap<>();
        //map.put("a","1");
        //map.put("b","2");
        //map.put("c","3");
        //List<String> list = new ArrayList<>(map.keySet());
        //Collections.shuffle(list);
        //String s = list.get(0);
        //System.out.println(s);
        //int i = compareVersion("2.0.4.1.2", "2.0.4.1.1");
        //if (i > 0) {
        //    System.out.println("左边大");
        //} else if (i < 0) {
        //    System.out.println("右边大");
        //} else {
        //    System.out.println("相等");
        //}
        //List<String> list = StrUtil.splitTrim("1 ,2 ,4,56,7", ",");
        //System.out.println(list);
        //[溢价率/(1+溢价率)-DSP返点]/(1-DSP返点)
        //BigDecimal divide;
        //divide = (BigDecimal.valueOf(50).divide(new BigDecimal("100")).divide(new BigDecimal("1").add(BigDecimal.valueOf(50).divide(new BigDecimal("100"))), 6, BigDecimal.ROUND_DOWN).subtract(BigDecimal.valueOf(20).divide(new BigDecimal("100"))))
        //        .divide(BigDecimal.valueOf(0), 4, BigDecimal.ROUND_HALF_UP);
        //boolean b = BigDecimal.valueOf(0.07).compareTo(divide) == 0;

        //BigDecimal divide1 = (BigDecimal.valueOf(50).divide(BigDecimal.valueOf(100))
        //        .divide(BigDecimal.valueOf(1).add(BigDecimal.valueOf(50).divide(BigDecimal.valueOf(100))), 6, BigDecimal.ROUND_DOWN).subtract(BigDecimal.valueOf(20).divide(BigDecimal.valueOf(100))))
        //        .divide(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(20).divide(BigDecimal.valueOf(100))), 4, BigDecimal.ROUND_DOWN);
        //Double divide2 = -100.000000;
        //boolean b = BigDecimal.valueOf(0).compareTo(BigDecimal.ZERO) == 0;
        //System.out.println(b);

        File file = new File("d:/test.jpg");
        URLConnection connection = file.toURL().openConnection();
        String mimeType = connection.getContentType();
        System.out.println(mimeType);

    }

    /**
     * 版本号比较
     *
     * @param v1
     * @param v2
     * @return 0代表相等，1代表左边大，-1代表右边大
     * Utils.compareVersion("1.0.358_20180820090554","1.0.358_20180820090553")=1
     */
    public static int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._]");
        String[] version2Array = v2.split("[._]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;

        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    public static Integer compareVersionByPointer(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();

        //两个指针
        int p = 0, q = 0;

        while (p < m || q < n) {
            //累加version1区间的数字
            int x = 0;
            while (p < m && version1.charAt(p) != '.') {
                x += x * 10 + (version1.charAt(p) - '0');
                p++;
            }

            //累加version2区间的数字
            int y = 0;
            while (q < n && version2.charAt(q) != '.') {
                y += y * 10 + (version2.charAt(q) - '0');
                q++;
            }

            //判断
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }

            //跳过.
            p++;
            q++;
        }
        //version1等于version2
        return 0;
    }

}
