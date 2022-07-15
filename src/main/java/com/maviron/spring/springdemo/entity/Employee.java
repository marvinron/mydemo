package com.maviron.spring.springdemo.entity;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Employee.java
 * @Description 领域实体类employ
 * @createTime 2022年07月14日 10:43:00
 */
public class Employee {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
