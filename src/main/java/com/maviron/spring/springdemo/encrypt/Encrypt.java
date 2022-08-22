package com.maviron.spring.springdemo.encrypt;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Encrypt.java
 * @Description 加密数据的实体类
 * @createTime 2022年08月04日 12:23:00
 */
public class Encrypt {
    private String value;
    public Encrypt() {
    }

    public Encrypt(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
