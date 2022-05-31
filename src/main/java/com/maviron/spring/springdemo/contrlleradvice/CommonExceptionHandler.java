package com.maviron.spring.springdemo.contrlleradvice;

import com.maviron.spring.springdemo.until.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CommonExceptionHandler.java
 * @Description 普通异常类的处理
 * @createTime 2022年04月25日 11:24:00
 */
@ControllerAdvice
public class CommonExceptionHandler {
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        return Result.error();
    };

}
