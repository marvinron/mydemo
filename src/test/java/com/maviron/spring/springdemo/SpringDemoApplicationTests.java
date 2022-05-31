package com.maviron.spring.springdemo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDemoApplicationTests {
    @Autowired
    private StringEncryptor stringEncryptor;
    @Test
    void contextLoads() {
        String encrypt = stringEncryptor.encrypt("jdbc:mysql://121.36.42.203:3306/bean_search?serverTimezone=Asia/Shanghai");
        String encrypt1 = stringEncryptor.encrypt("hl424801@");
        System.out.println("==========="+encrypt);
        System.out.println("+++++++++++"+encrypt1);
    }

}
