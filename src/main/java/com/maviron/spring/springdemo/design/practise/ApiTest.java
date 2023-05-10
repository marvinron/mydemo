package com.maviron.spring.springdemo.design.practise;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ApiTest {

    @Test
    public void test_MQAdapter() throws Exception {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2023-02-27 20:20:16");

        CreateAccount createAccount = new CreateAccount();
        createAccount.setNumber("1000");
        createAccount.setAddress("北京");
        createAccount.setAccountDate(parse);
        createAccount.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(JSON.toJSONString(createAccount), link01);
        System.out.println("mq.createAccount(适配前)" + createAccount.toString());
        System.out.println("mq.createAccount(适配后)" + JSON.toJSONString(rebateInfo01));
    }
}