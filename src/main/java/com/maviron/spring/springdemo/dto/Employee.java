package com.maviron.spring.springdemo.dto;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import com.ejlchina.searcher.operator.Contain;
import com.ejlchina.searcher.operator.StartWith;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.maviron.spring.springdemo.constant.Gender;

import java.time.LocalDateTime;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Employee.java
 * @Description TODO
 * @createTime 2022年03月15日 09:41:00
 */
@SearchBean(
        tables = "employee e, department d",
        joinCond = "e.department_id = d.id",
        autoMapTo = "e"							// 字段没使用 DbField 注解时，自动映射到 employee 表
)
public class Employee extends BaseBean {

    @DbField(onlyOn = { StartWith.class, Contain.class })
    private String name;

    private Integer age;

    private Gender gender;

    @DbField("d.name")
    private String department;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime entryDate;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

}
