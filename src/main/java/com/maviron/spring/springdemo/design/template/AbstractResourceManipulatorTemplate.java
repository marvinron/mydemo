package com.maviron.spring.springdemo.design.template;

import com.maviron.spring.springdemo.function.functionmode.Resource;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstractResourceManipulatorTemplate.java
 * @Description 模板方法
 * @createTime 2022年07月14日 14:20:00
 */
public abstract class AbstractResourceManipulatorTemplate {
    protected Resource resource;

    private void openResource() {
        resource = new Resource();
    }

    public abstract void doSomethingWithResource();

    public void execute(){
        openResource();
        try {
            doSomethingWithResource();
        }finally {
            closeResource();
        }
    }
    private void closeResource() {
        resource.dispose();
        resource = null;
    }

}
