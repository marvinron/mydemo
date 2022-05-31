package com.maviron.spring.springdemo.demo;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BaseService.java
 * @Description TODO
 * @createTime 2021年11月22日 15:51:00
 */
public abstract class BaseService<Request, Response> {
    public final Response service(Request request) {
        System.out.println("调用公共的service");
        // 各个子类实现
        validateRequest(request);
        // 各个子类实现，具体业务逻辑, 此处省略getBiz获取各个子类实际业务逻辑类
        /*Response response = getBiz().biz(request);*/
        System.out.println("结束调用公共的service");
        // 只是展示
        return null;
    }

    protected abstract void validateRequest(Request request);
}
