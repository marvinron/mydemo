package com.maviron.spring.springdemo.until;

import cn.hutool.crypto.digest.DigestUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * @author poker.li
 * @date 2021/8/28 16:22
 * <p>
 * 进制转换工具类
 */
public class ConversionUtils {

    /**
     * 61进制字符,不使用0是因为转换后的字符长度不足5位时使用0填充
     */
    private static final String CHARS = "oNWxUYwrXdCOIj4ck6M8RbiQa3H91pSmZTAh7zquLnKvt2VyEGlBsPJgDe5Ff";
    private static final int SCALE = 61;
    private static final int MIN_LENGTH = 5;

    private static final String[] DEFAULT_CHARS = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };

    /**
     * 将数字转换成61进制字符,至少五位,不足用0填充
     *
     * @param num 数字
     * @return 反转后的61位字符串, 不足五位使用0从左边开始填充
     */
    public static String encodeTo61(long num) {
        IAssert.state(num >= 0, "The number must be greater than zero");
        StringBuilder builder = new StringBuilder();
        int remainder;
        while (num > SCALE - 1) {
            remainder = (int) (num % SCALE);
            builder.append(CHARS.charAt(remainder));
            num = num / SCALE;
        }
        builder.append(CHARS.charAt((int) num));
        String value = builder.reverse().toString();
        //至少五位,不足用0填充
        return StringUtils.leftPad(value, MIN_LENGTH, '0');
    }

    /**
     * 将经过{@link ConversionUtils#encodeTo61(long)}方法转换后的字符串还原成对应的数字
     *
     * @param input 转换后的字符串
     * @return 原始数字
     */
    public static long decodeTo61(String input) {
        IAssert.notNullStr(input, "The input string must be not empty");
        input = input.replaceAll("^0*", "");
        long value = 0;
        char tempChar;
        int tempCharValue;
        for (int i = 0; i < input.length(); i++) {
            tempChar = input.charAt(i);
            //系数
            tempCharValue = CHARS.indexOf(tempChar);
            value += tempCharValue * NumberUtils.pow(SCALE, input.length() - i - 1);
        }
        return value;
    }

    public static String[] toShortUrl(String rawUrl) {
        String md5Hex = DigestUtil.md5Hex(rawUrl);
        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {
            String sTempSubString = md5Hex.substring(i * 8, i * 8 + 8);
            long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16);
            StringBuilder outChars = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                //永远无法取到 2^n + 2 和 2^n + 3
                long index = 0x0000003D & lHexLong;
                outChars.append(DEFAULT_CHARS[(int) index]);
                lHexLong = lHexLong >> 5;
            }
            resUrl[i] = outChars.toString();
        }
        return resUrl;
    }

    public static void main(String[] args) {
        System.out.println(encodeTo61(1376339701643390977L));

    }

}