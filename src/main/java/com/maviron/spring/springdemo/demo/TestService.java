package com.maviron.spring.springdemo.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestService.java
 * @Description TODO
 * @createTime 2021年11月22日 15:53:00
 */
public class TestService extends BaseService {
    public Object getResponse(Object req){
        return service(req);
    }
    @Override
    protected void validateRequest(Object o) {
        System.out.println("来自testservice的验证");
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("5","12");
        jsonObject.put("6","13");
        jsonObject.put("7","11");
        jsonObject.put("8","10");
        List<Integer> collect = jsonObject.keySet().stream().map(Integer::valueOf).filter(value -> value > 6).collect(Collectors.toList());
        int sum = jsonObject.entrySet().stream().filter(entry -> Integer.valueOf(entry.getKey()) > 6).mapToInt(entry -> Integer.parseInt((String) entry.getValue())).sum();
        JSONObject jsonObject1 = JSONObject.parseObject("");
        System.out.println(jsonObject1.getString("dabai"));
        System.out.println(sum);
        System.out.println(collect);
    }
}
