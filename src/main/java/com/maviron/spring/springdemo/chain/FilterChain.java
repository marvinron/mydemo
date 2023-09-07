package com.maviron.spring.springdemo.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(Request request) {
        if (index < filters.size()) {
            Filter filter = filters.get(index);
            index++;
            filter.doFilter(request, this);
        }
    }
}