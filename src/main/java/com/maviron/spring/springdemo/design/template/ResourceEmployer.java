package com.maviron.spring.springdemo.design.template;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ResourceEmployer.java
 * @Description 资源使用者2
 * @createTime 2022年07月14日 14:26:00
 */
public class ResourceEmployer extends AbstractResourceManipulatorTemplate {
    @Override
    public void doSomethingWithResource() {
        resource.employResource();
    }
}
