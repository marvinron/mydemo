package com.maviron.spring.springdemo.until;

/**
 * @author poker.li
 * @date 2021/8/28 18:07
 * <p>
 * 数字工具类
 */
public final class NumberUtils {

    /**
     * 求幂
     *
     * @param x 基数
     * @param n 幂
     * @return 结果
     */
    public static long pow(long x, int n) {
        long pow = 1;
        if (n == 0) {
            return 1;
        }
        while (n > 0) {
            if ((n & 1) != 0) {
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }
}
