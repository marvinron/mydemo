package com.maviron.spring.springdemo.until;

import com.maviron.spring.springdemo.constant.StatusCode;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 描述 返回封装
 * @version 1.0
 * @package entity *
 * @since 1.0
 */
public class Result<T> implements Serializable {
    //是否成功
    private boolean flag;
    //返回码
    private Integer code;
    //返回消息
    private String message;
    //返回数据
    private T data;

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.flag = true;
        this.code = StatusCode.OK;
        this.message = StatusCode.OK_MSG;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success(){
        return new Result();
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setData(data);
        return result;
    }

    public static Result success(Integer code, Object data){
        Result result = new Result();
        if (StringUtils.isNotBlank(StatusCode.msgMap.get(code))){
            result.setCode(code);
            result.setMessage(StatusCode.msgMap.get(code));
        }
        result.setData(data);
        return result;
    }

    public static Result success(Integer code, String message, Object data){
        return new Result(true, code, message, data);
    }

    public static Result error(){
        return new Result(false, StatusCode.ERROR, StatusCode.ERROR_MSG);
    }

    public static Result error(String message){
        return new Result(false, StatusCode.ERROR, message);
    }

    public static Result error(Integer code, String message){
        return new Result(false, code, message);
    }

    public static Result error(Integer code){
        Result result = new Result(false, code, null);
        if (StringUtils.isNotBlank(StatusCode.msgMap.get(code))){
            result.setCode(code);
            result.setMessage(StatusCode.msgMap.get(code));
        }
        return result;
    }
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
