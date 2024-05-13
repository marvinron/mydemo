package com.maviron.spring.springdemo.until;
/**
 * 如果生成7位随机数  数字和字母的组合 达到3.5万亿
 */

import java.security.SecureRandom;

public class RandomCodeGenerator {
    private static final String CHAR_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomCode(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(CHAR_62.length());
            char rndChar = CHAR_62.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
