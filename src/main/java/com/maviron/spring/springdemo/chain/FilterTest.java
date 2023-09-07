package com.maviron.spring.springdemo.chain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName FilterTest.java
 * @Description TODO
 * @createTime 2023年09月07日 10:30:00
 */
public class FilterTest {

    public static void main(String[] args) {
        Request request = new Request("data");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FilterA());
        filterChain.addFilter(new FilterB());

        filterChain.doFilter(request);
    }

}
