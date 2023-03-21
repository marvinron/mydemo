package com.maviron.spring.springdemo.aspringexpand.factorybean;

import com.maviron.spring.springdemo.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName UserFactoryBean.java
 * @Description 扩展FactoryBean接口
 * @createTime 2023年03月15日 18:16:00
 * @see org.springframework.beans.factory.FactoryBean
 */
@Configuration
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        System.out.println("调用UserFactoryBean的Object 方法生成bean " + user);
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
