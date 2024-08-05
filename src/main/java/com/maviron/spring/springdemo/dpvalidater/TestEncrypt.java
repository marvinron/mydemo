package com.maviron.spring.springdemo.dpvalidater;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestEncrypt.java
 * @Description TODO
 * @createTime 2024年08月01日 10:34:00
 */
public class TestEncrypt {

    public static String encrypt(String data, String aesKey, String aesIv) throws Exception {
        // JSON编码
        String jsonData = data;
        // if (jsonData.length() % 16 != 0) {
        //     jsonData = String.format("%-" + (jsonData.length() + 16 - jsonData.length() %
        //             16) + "s", jsonData).replace(' ', '\0');
        //
        //
        // }
        // if (Objects.equals(data, jsonData)) {
        //     System.out.println(data);
        //     System.out.println(jsonData);
        // }
        // System.out.println(1);
        // System.out.println(data);
        // System.out.println(jsonData);
        // AES加密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        SecretKeySpec secretKeySpec = new
                SecretKeySpec(aesKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameterSpec = new
                IvParameterSpec(aesIv.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedData = cipher.doFinal(jsonData.getBytes(StandardCharsets.UTF_8));

        // Base64编码
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static void main(String[] args) throws Exception {
        String str = "{\"mobile\":\"15815838486\",\"name\":\"黄伟\",\"city\":\"成都市\",\"loan_limit\":4,\"sex\":1,\"age\":39,\"operating_system_type\":\"android\",\"ip\":\"47.107.61.164\",\"sesame_points\":4,\"car\":1,\"house\":1,\"fund\":1,\"social\":1,\"insurance\":1,\"businessLicense\":0,\"iou_quota\":3,\"flowers_quota\":3,\"credit_card\":1,\"expect_status\":2}";
        String encrypt = encrypt(str, "sSfG8tKT3b5qkza9", "WTcbTfD3k61ekmF4");
        System.out.println("================"+encrypt);
    }
}
