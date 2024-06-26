package com.maviron.spring.springdemo.demo.web;

import cn.hutool.core.bean.BeanUtil;
import com.google.common.base.Strings;
import com.maviron.spring.springdemo.until.BeanCopyUtil;
import com.maviron.spring.springdemo.until.BeanMapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

public class KaisaUtil {
    /***
     * 使用凯撒加密方式加密数据
     * @param orignal 原文
     * @param key 密钥
     * @return 加密后的字符
     */
    private static String encryptKaisa(String orignal, int key) {
        //将字符串转换为数组
        char[] chars = orignal.toCharArray();
        StringBuffer buffer = new StringBuffer();
        //遍历数组
        for(char aChar : chars) {
            //获取字符的ASCII编码
            int asciiCode = aChar;
            //偏移数据
            asciiCode += key;
            //将偏移后的数据转为字符
            char result = (char)asciiCode;
            //拼接数据
            buffer.append(result);
        }
        return buffer.toString();
    }    
    /**
     * 使用凯撒加密方式解密数据
     *
     * @param encryptedData :密文
     * @param key           :密钥
     * @return : 源数据
     */
    private static String decryptKaiser(String encryptedData, int key) {
        // 将字符串转为字符数组
        char[] chars = encryptedData.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 遍历数组
        for (char aChar : chars) {
            // 获取字符的ASCII编码
            int asciiCode = aChar;
            // 偏移数据
            asciiCode -= key;
            // 将偏移后的数据转为字符
            char result = (char) asciiCode;
            // 拼接数据
            sb.append(result);
        } 
        return sb.toString();
    }

    /**
     * Ascii转换为字符串
     * @param value
     * @return
     */
    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();

    }


    public static void main(String[] args) {
        //String string = stringToAscii("dgdvgd");
        //System.out.println(string);
        String s = encryptKaisa("123213", 100);
        System.out.println(s);
    }    
}