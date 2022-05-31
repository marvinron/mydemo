package com.maviron.spring.springdemo.demo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maviron.spring.springdemo.entity.User;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class TestDemo {

    public static void main(String[] args) throws UnsupportedEncodingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("dabai");
        user1.setAge(12);
        user1.setSequence(1);
        list.add(user1);
        User user2 = new User();
        user2.setName("dabai2");
        user2.setAge(14);
        user2.setSequence(2);
        list.add(user2);
        User user3 = new User();
        user3.setName("dabai3");
        user3.setAge(12);
        user3.setSequence(3);
        list.add(user3);
        User user4 = new User();
        user4.setName("dabai4");
        user4.setAge(15);
        user4.setSequence(4);
        list.add(user4);
        User user5 = new User();
        user5.setName("dabai5");
        user5.setAge(15);
        user5.setSequence(5);
        list.add(user5);
        list.sort(Comparator.comparing((User f)->Integer.valueOf(f.getSequence())));
        System.out.println("----------"+list);
        System.out.println("======="+JSONObject.toJSONString(list));
        List<User> result = new ArrayList<>();
        Map<Integer, List<User>> collectMap =
                list.stream().collect(Collectors.groupingBy(User::getAge,LinkedHashMap::new,Collectors.toCollection(ArrayList::new)));
        collectMap.forEach((k,v)->{
            Collections.shuffle(v);
            result.addAll(v);
        });
        //
        System.out.println(JSONObject.toJSONString(result));
        System.out.println("=="+JSONObject.toJSONString(collectMap));
        String string = objectMapper.writeValueAsString(list);
        System.out.println(string);
        boolean equals = Objects.equals("1", "2");



        //boolean b = (new BigDecimal(10).subtract(new BigDecimal(5)).subtract(new BigDecimal(5))).compareTo(BigDecimal.ZERO) <= 0;
        //System.out.println(b);

        //String encode = URLEncoder.encode("[ximei]", "UTF-8");
        //String url = "http://www.baidu.com?key=value&url=";
        //url+=URLEncoder.encode("http://www.sina.com?a=b","UTF-8");
        //String encode1 = URLEncoder.encode(url, "UTF-8");
        //System.out.println(url);

        //MultiMap<String, String> map = new MultiValueMap<>();
        //Map<Integer, String> IdentityHashMap = new IdentityHashMap<>();
        //IdentityHashMap.put(new Integer(1),"dad");
        //IdentityHashMap.put(new Integer(1),"dad");
        //IdentityHashMap.put(new Integer(1),"dad");
        //IdentityHashMap.put(new Integer(1),"dad");
        //IdentityHashMap.put(new Integer(1),"dad");
        //System.out.println("遍历方式2:foreach方式遍历键值对Set集合的-----------------------------");
        //boolean b = BigDecimal.valueOf(50).compareTo(new BigDecimal(2).multiply(BigDecimal.valueOf(100))) > 0;
        //System.out.println(b);

        //dspComprehensiveReports.stream()
        //        .collect(Collectors.toMap(DspComprehensiveReport::getDay, item -> item, (v1, v2) -> {return v2;}));

        //Map<Integer, User> collect = list.stream()
        //        .collect(Collectors.toMap(User::getAge, item -> item, (v1, v2) -> {return v2;}));
        //System.out.println(collect);
        //list.forEach(u->{
        //    if(u.getAge()==12){
        //        list.remove(u);
        //    }
        //});
        //Iterator<User> iterator = list.iterator();
        //while (iterator.hasNext()) {
        //    User next = iterator.next();
        //    if(next.getAge() == 12){
        //        iterator.remove();
        //    }
        //}
        //System.out.println(list.toString());
        //double v = new BigDecimal("0").doubleValue();
        //if (v == 0.0) {
        //    System.out.println("true");
        //}else {
        //    System.out.println("false");
        //}
        //Map<Integer,Double> timeDisMap = new HashMap<>();
        //timeDisMap.put(1,0.05);
        //timeDisMap.put(2,0.05);
        //timeDisMap.put(3,0.05);
        //timeDisMap.put(4,0.05);
        //timeDisMap.put(5,0.05);
        //timeDisMap.put(6,0.05);
        //timeDisMap.put(7,0.05);
        //timeDisMap.put(8,0.05);
        //timeDisMap.put(9,0.05);
        //timeDisMap.put(10,0.05);
        //timeDisMap.put(11,0.05);
        //timeDisMap.put(12,0.05);
        //timeDisMap.put(13,0.05);
        //timeDisMap.put(14,0.05);
        //timeDisMap.put(15,0.05);
        //timeDisMap.put(16,0.05);
        //timeDisMap.put(17,0.05);
        //timeDisMap.put(18,0.05);
        //timeDisMap.put(19,0.02);
        //timeDisMap.put(20,0.02);
        //timeDisMap.put(21,0.02);
        //timeDisMap.put(22,0.02);
        //timeDisMap.put(23,0.01);
        //timeDisMap.put(24,0.01);
        //int startTimeHour = -1;
        //int[] hourArray = {6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        //float timeDistribute = 0;
        //for (int i = 0; i < hourArray.length; i++) {
        //    if (hourArray[i] == 1) {
        //        timeDistribute += timeDisMap.get(i);
        //        if(startTimeHour < 0){
        //            startTimeHour = i; // 设置每个投放设定的起始投放时间（精确到小时）
        //        }
        //    }
        //}
        //System.out.println(timeDistribute);

    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static String paramJson(String paramIn) {
        paramIn = paramIn.replaceAll("=", "\":\"");
        paramIn = paramIn.replaceAll("&", "\",\"");
        return "{\"" + paramIn + "\"}";
    }

    public static boolean test() {
        for (int i = 0; i < 2; i++) {
            System.out.println("==========");
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean test(String string) {
        String[] strs = string.split(",");
        int[] array = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            array[i] = Integer.parseInt(strs[i]);
            if (i > 0 && Math.abs(array[i] - array[i - 1]) == 1) {
                return false;
            }
        }
        return true;
    }
}