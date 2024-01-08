package com.maviron.spring.springdemo.entity;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年01月10日 09:22:00
 */
//@Configuration
public class User implements Serializable {
    private static final long serialVersionUID = 1015995795755954005L;
    private String id;

    @NotNull(message = "姓名不能为空")
    @Size(min = 1, max = 20, message = "姓名长度必须在1-20之间")
    //@Value("${name}")
    private String name;

    @Min(value = 10, message = "年龄必须大于10")
    @Max(value = 150, message = "年龄必须小于150")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    private Long sequence;
    private UserVo userVo;
    private Double salery;


    public Double getSalery() {
        return salery;
    }

    public void setSalery(Double salery) {
        this.salery = salery;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sequence=" + sequence +
                '}';
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"id\": \"\",\n" +
                "  \"name\": \"\",\n" +
                "  \"age\": 0,\n" +
                "  \"email\": \"\",\n" +
                "  \"sequence\": \"80\",\n" +
                "}";
        User user = JSONObject.parseObject(json, User.class);
        System.out.println(user);
        MailAccount account = new MailAccount();
        account.setHost("smtp.163.com");
        account.setPort(25);
        //account.setAuth(true);
        account.setFrom("houlei801@163.com");
        account.setUser("houlei801@163.com");
        account.setPass("PFUOFODCGSVXRMQL");
        //account.setSslEnable(true);

        MailUtil.send(account, "houlei801@163.com", "大数据发送的信息", "value", false);
    }
}
