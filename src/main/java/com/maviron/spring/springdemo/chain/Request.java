package com.maviron.spring.springdemo.chain;

import java.util.Arrays;

public class Request {
    private String data;
    private Integer status;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static void main(String[] args) {
        Integer[] scores = {89, 100, 77, 90,  86};
        Arrays.sort(scores,Integer::compareTo);
    }
}










