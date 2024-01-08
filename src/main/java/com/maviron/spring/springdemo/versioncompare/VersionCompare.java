package com.maviron.spring.springdemo.versioncompare;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName VersionCompare.java
 * @Description TODO
 * @createTime 2024年01月08日 09:44:00
 */
public class VersionCompare {

    public static void main(String[] args) {
        int i = compareVersion("1.0.2", "0.0.1");
        System.out.println(i);
        Integer integer = compareVersionByPointer("1.0.2", "0.0.1");
        System.out.println(integer);
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
