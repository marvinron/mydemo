package com.maviron.spring.springdemo.responsibilitychain.example;

import com.maviron.spring.springdemo.until.Result;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName HandlerClient.java
 * @Description TODO
 * @createTime 2024年04月12日 18:03:00
 */
public class HandlerClient {
    public static Result executeChain(AbstractCheckHandler handler, ProductVO param) {
        //执行处理器
        Result handlerResult = handler.handle(param);
        if (!handlerResult.isFlag()) {
            System.out.println("HandlerClient 责任链执行失败返回：" + handlerResult.toString());
            return handlerResult;
        }
        return Result.success();
    }
}
