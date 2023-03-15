package com.maviron.spring.springdemo.test;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    /**
     * 方法功能说明：@1.带秘钥加密
     *
     * @param text明文
     * @param key密钥
     * @return 32位密文
     * 创建时间：2020年8月31日 上午10:51:40 --lud
     */
    public static String md5(String text, String key) throws Exception {
        if (key == null) {
            key = "";
        }
        return DigestUtils.md5Hex(text + key);
    }

    /**
     * 方法功能说明：@1.明文加密
     *
     * @param text明文
     * @return 32位密文
     * 创建时间：2020年8月31日 上午10:51:40 --lud
     */
    public static String md5(String text) throws Exception {
        return DigestUtils.md5Hex(text);
    }

    /**
     * 方法功能说明：@1.MD5验证方法,根据传入的密钥进行验证
     *
     * @param text明文
     * @param key密钥
     * @param md5密文  创建时间：2020年8月31日 上午10:50:57 --lud
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }

}