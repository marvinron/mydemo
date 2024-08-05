package com.maviron.spring.springdemo.dpvalidater;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2024年07月31日 17:05:00
 */
public class Test {

    public static String encrypt(String data, String aesKey, String aesIv) throws Exception {
        // JSON编码
        String jsonData = data;
        byte[] plainTextBytes = jsonData.getBytes(Charset.forName("UTF-8"));
        int paddingBytes = 16 - (plainTextBytes.length % 16);
        byte[] paddedBytes = new byte[plainTextBytes.length + paddingBytes];

        // 复制原始数据到补位后的数组
        System.arraycopy(plainTextBytes, 0, paddedBytes, 0, plainTextBytes.length);

        // 补位
        for (int i = plainTextBytes.length; i < paddedBytes.length; i++) {
            paddedBytes[i] = (byte) paddingBytes;
        }
        if (Objects.equals(data, jsonData)) {
            System.out.println(data);
            System.out.println(jsonData);
        }
        System.out.println(1);
        System.out.println(data);
        System.out.println(jsonData);
        // AES加密
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        SecretKeySpec secretKeySpec = new
                SecretKeySpec(aesKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new
                IvParameterSpec(aesIv.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedData = cipher.doFinal(paddedBytes);

        // Base64编码
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    //aesKey：sSfG8tKT3b5qkzasSfG8tKT3b5qkzasSfG8tKT3b5qkzasSfG8tKT3b5qkza    aesIv：WTcbTfD3k61ekmF4WTcbTfD3k61ekmF4WTcbTfD3k61ekmF4WTcbTfD3k61ekmF4
    public static void main(String[] args) throws Exception {
        String str = "{\"mobile\":\"15815838486\",\"name\":\"黄伟\",\"city\":\"成都市\",\"loan_limit\":4,\"sex\":1,\"age\":39,\"operating_system_type\":\"android\",\"ip\":\"47.107.61.164\",\"sesame_points\":4,\"car\":1,\"house\":1,\"fund\":1,\"social\":1,\"insurance\":1,\"businessLicense\":0,\"iou_quota\":3,\"flowers_quota\":3,\"credit_card\":1,\"expect_status\":2}";
        String encrypt = encrypt(str, "sSfG8tKT3b5qkza9", "WTcbTfD3k61ekmF4");
        System.out.println("========="+encrypt);
    }
}
