package com.maviron.spring.springdemo.dao;

import com.maviron.spring.springdemo.design.chain.SignUpCommand;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2023年05月06日 16:47:00
 */
public interface UserRepository {

    SignUpCommand findByUsername(String userName);
    SignUpCommand findByEmail(String email);
}
