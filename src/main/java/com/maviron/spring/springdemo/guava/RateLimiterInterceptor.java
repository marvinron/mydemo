package com.maviron.spring.springdemo.guava;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.maviron.spring.springdemo.until.Result;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterInterceptor extends HandlerInterceptorAdapter {

    private final RateLimiter rateLimiter;

    /**
     * 通过构造函数初始化限速器
     */
    public RateLimiterInterceptor(RateLimiter rateLimiter) {
        super();
        this.rateLimiter = rateLimiter;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (this.rateLimiter.tryAcquire()) {
            /**
             * 成功获取到令牌
             */
            return true;
        }

        /**
         * 获取失败，直接响应“错误信息”
         * 也可以通过抛出异常，通过全全局异常处理器响应客户端
         */
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().write(JSONObject.toJSONString(Result.success(Collections.EMPTY_LIST)));
        return false;
    }
}