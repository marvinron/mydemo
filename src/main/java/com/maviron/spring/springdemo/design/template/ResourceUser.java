package com.maviron.spring.springdemo.design.template;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ResourceUser.java
 * @Description 资源使用者1
 * @createTime 2022年07月14日 14:25:00
 */
public class ResourceUser extends AbstractResourceManipulatorTemplate {

    @Override
    public void doSomethingWithResource() {
        resource.useResource();
    }
}
