package com.maviron.spring.springdemo.chain;

public interface Filter {
    void doFilter(Request request, FilterChain chain);
}