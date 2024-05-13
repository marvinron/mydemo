package com.maviron.spring.springdemo.until;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

/**
 * 通过 Google的 MurmurHash算法把长链 Hash成一个 32位的 10进制正数，
 * 然后再转换成62进制（压缩），这样就可以得到一个 6位随机数
 */
public class MurmurHashToBase62 {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String toBase62(int value) {
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.insert(0, BASE62.charAt(value % 62));
            value /= 62;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // 长链
        String input = "https://yuanjava.cnposts/short-link-system/design?code=xsd&page=1";
        // 长链利用 MurmurHash算法生成 32位 10进制数
        HashFunction hashFunction = Hashing.murmur3_32();
        int hash = hashFunction.hashString(input, StandardCharsets.UTF_8).asInt();
        if (hash < 0) {
            hash = hash & 0x7fffffff; // Convert to positive by dropping the sign bit
        }
        // 将 32位 10进制数 转换成 62进制
        String base62Hash = toBase62(hash);
        System.out.println("base62Hash:" + base62Hash);
    }
}
