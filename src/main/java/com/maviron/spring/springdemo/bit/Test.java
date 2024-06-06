package com.maviron.spring.springdemo.bit;

public class Test {
    //6400万可用 大约占用内存72M
    public static volatile long[] longArr = new long[10000000];

    /**
     * 系统有一接口，根据id查询数据库（id为+7自增），无权限即可访问，所有经常会有爬虫爬，导致无效请求查数据库压力比较大
     * 使用bit存储存在的id判断id是否存在
     * 只演示bit使用，不讨论其他情况
     */
    public static void main(String[] args) {
        setData(100);
        System.out.println(existData(100));
        System.out.println(existData(101));
    }

    public static void setData(int data) {
        //算数组下标 右移6位 相当于 data/64
        int index = data >> 6;
        //1L 左移data位相当于 data%64
        longArr[index] |= 1L << data;
    }

    public static boolean existData(int data) {
        //算数组下标
        int index = data >> 6;
        return (longArr[index] & 1L << data) != 0;
    }

}