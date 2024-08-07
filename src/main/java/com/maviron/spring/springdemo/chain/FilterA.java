package com.maviron.spring.springdemo.chain;

public class FilterA implements Filter {
    @Override
    public void doFilter(Request request, FilterChain chain) {
        // 处理请求
        System.out.println("Filter A processing request: " + request.getData());

        // 调用下一个过滤器
        chain.doFilter(request);
    }
}