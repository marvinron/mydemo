package com.maviron.spring.springdemo.proxy.jdknativeproxy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.time.LocalDate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description 代理接口的实现类
 * @createTime 2022年04月24日 10:56:00
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("逻辑执行了哈。。。。。。");
    }

    public static void main(String[] args) {
        String str = "[\n" +
                "\t{\n" +
                "\t\t\"week\": 1,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t10,\n" +
                "\t\t\t11,\n" +
                "\t\t\t12,\n" +
                "\t\t\t13,\n" +
                "\t\t\t14\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"week\": 2,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t12,\n" +
                "\t\t\t15,\n" +
                "\t\t\t17,\n" +
                "\t\t\t18,\n" +
                "\t\t\t19,\n" +
                "\t\t\t20,\n" +
                "\t\t\t21,\n" +
                "\t\t\t22,\n" +
                "\t\t\t23\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"week\": 3,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t12,\n" +
                "\t\t\t13,\n" +
                "\t\t\t14,\n" +
                "\t\t\t15,\n" +
                "\t\t\t17,\n" +
                "\t\t\t18,\n" +
                "\t\t\t19,\n" +
                "\t\t\t20\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"week\": 4,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t12,\n" +
                "\t\t\t13,\n" +
                "\t\t\t14,\n" +
                "\t\t\t15,\n" +
                "\t\t\t17,\n" +
                "\t\t\t18,\n" +
                "\t\t\t19,\n" +
                "\t\t\t20\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"week\": 5,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t12,\n" +
                "\t\t\t13,\n" +
                "\t\t\t14,\n" +
                "\t\t\t15,\n" +
                "\t\t\t17,\n" +
                "\t\t\t18,\n" +
                "\t\t\t19,\n" +
                "\t\t\t20\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"week\": 6,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t10,\n" +
                "\t\t\t11,\n" +
                "\t\t\t12,\n" +
                "\t\t\t13,\n" +
                "\t\t\t14,\n" +
                "\t\t\t15\n" +
                "\t\t]\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"week\": 7,\n" +
                "\t\t\"hour\": [\n" +
                "\t\t\t0,\n" +
                "\t\t\t1,\n" +
                "\t\t\t2,\n" +
                "\t\t\t3,\n" +
                "\t\t\t4,\n" +
                "\t\t\t5,\n" +
                "\t\t\t6,\n" +
                "\t\t\t7,\n" +
                "\t\t\t8,\n" +
                "\t\t\t9,\n" +
                "\t\t\t10,\n" +
                "\t\t\t11,\n" +
                "\t\t\t12,\n" +
                "\t\t\t13,\n" +
                "\t\t\t14,\n" +
                "\t\t\t15\n" +
                "\t\t]\n" +
                "\t}\n" +
                "]";
        JsonParser parser=new JsonParser();
        JsonElement je=parser.parse(str);
        Gson gson=new GsonBuilder().serializeNulls().create();
        System.out.println(gson.toJson(je));
    }
}
