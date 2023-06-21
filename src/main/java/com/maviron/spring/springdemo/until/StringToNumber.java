package com.maviron.spring.springdemo.until;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.HashUtil;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class StringToNumber {
    public static long toNumber(String str) {
        // 使用MurmurHash算法生成一个32位数字
        int hashValue = Hashing.murmur3_32().hashString(str, StandardCharsets.UTF_8).asInt();

        // 取前9位作为结果
        long mod = 100;
        long digit = Math.abs((long) hashValue) % mod;

        // 如果不足9位，在前面补0
        String number = String.format("%02d", digit);
        return Long.parseLong(number);
    }

    public static long getNumberStr() {
        String str = java.util.UUID.randomUUID().toString().replace("-", "");
        return toNumber(str);
    }


    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        StopWatch stop = new StopWatch();
        stop.start();
        for (int i = 0; i < 100; i++) {
            String str = java.util.UUID.randomUUID().toString().replace("-", "");
            //long number = toNumber(str);
            //System.out.println(number);
            //int hashValue = Hashing.murmur3_32().hashString(str, StandardCharsets.UTF_8).asInt();
            long hashValue = HashUtil.mixHash(str);
            //long hashValue = HashUtil.fnvHash(str);
        }
        stop.stop();
        System.out.println(stop.getTotalTimeMillis());
    }
}