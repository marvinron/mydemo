package com.maviron.spring.springdemo.dpvalidater;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;  
import javax.crypto.spec.SecretKeySpec;  
import org.apache.commons.codec.binary.Base64;

public class AESUtil {  
    
    private static final String ALGORITHM = "AES";  
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";  
    
    public static String encrypt(String data, String key, String iv) throws Exception {  
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);  
        IvParameterSpec ivParams = new IvParameterSpec(iv.getBytes());  
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);  
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);  
        byte[] encrypted = cipher.doFinal(data.getBytes());  
        return Base64.encodeBase64String(encrypted);  
    }  

    public static String decrypt(String encryptedData, String key, String iv) throws Exception {  
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);  
        IvParameterSpec ivParams = new IvParameterSpec(iv.getBytes());  
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);  
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParams);  
        byte[] original = cipher.doFinal(Base64.decodeBase64(encryptedData));
        // return new String(original);
        return new String(original);
    }

    public static void main(String[] args) {  
        String key = "sSfG8tKT3b5qkza9"; // 16 bytes for AES-128
        String iv = "WTcbTfD3k61ekmF4";  // 16 bytes for the IV
        String data = "Hello, AES-128-CBC!";  

        try {  
            String encryptedData = encrypt(data, key, iv);  
            System.out.println("Encrypted: " + encryptedData);  

            String decryptedData = decrypt(encryptedData, key, iv);  
            System.out.println("Decrypted: " + decryptedData);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}