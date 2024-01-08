package com.maviron.spring.springdemo.test;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.maviron.spring.springdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年01月04日 09:53:00
 */
public class Test {
    private static final String KEY = "traceId";
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        //System.out.println(timeStr);
        //MDC.put(KEY,UUID.randomUUID().toString());
        //LOG.info("获取当前的线程{}",Thread.currentThread().getName());
        //LOG.info("获取当前的线程的ID号{}",Thread.currentThread().getId());
        //LOG.info("获取当前的线程的优先级{}",Thread.currentThread().getPriority());
        //MDC.remove(KEY);
        //List<String> list1 = new ArrayList<>();
        //list1.add("1");
        //list1.add("2");
        //list1.add("3");
        //List<String> list2 = new ArrayList<>();
        //list2.add("a");
        //list2.add("b");
        //list2.add("c");
        //List<String> collect = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());
        //System.out.println(collect);
        //Class<User> userClass = User.class;
        //JSON.parseObject("",Object.class);
        //User user = User.class.newInstance();
        //user.setAge(12);
        //user.setName("21321");
        //System.out.println(user.toString());

        //List<String> list = new ArrayList<>();
        //list.add("00001");
        //list.add("00004");
        //list.add("00007");
        //list.add("00010");
        //list.add("00013");
        //for (int j = 0; j < 10;j++) {
        //    double random = Math.random();
        //    System.out.println(random);
        //    int v = (int)(Math.random() * 10 + 1);
        //    System.out.println(v);
        //    int i = RandomUtil.randomInt(100)+1;
        //    System.out.println(i);
        //}

        //List<String> stringList = Arrays.asList("hello", "world", "java", "stream");
        //Map<Integer, List<String>> collect = stringList.stream().collect(Collectors.groupingBy(String::length));
        //System.out.println(collect);
        //
        //List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //
        //Map<Boolean, List<Integer>> result = numberList.stream()
        //        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        //
        //System.out.println(result);

        //Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        //        .limit(10)
        //        .map(t -> t[0])
        //        .forEach(System.out::println);
        //Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).map(t -> t[0]).forEach(System.out::println);
        //
        //List<String> list1 = Arrays.asList("hello", "world");
        //List<String> list2 = Arrays.asList("java", "stream");
        //List<String> collect = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        //System.out.println(collect);

        //List<Integer> numberList = Arrays.asList(1, 3, 2, 4, 10, 6, 8, 7, 9, 6);
        //
        //List<Integer> result = numberList.stream()
        //        .sorted()
        //        .unordered()
        //        .collect(Collectors.toList());
        //
        //System.out.println(result);
        //
        //String string = BigDecimal.valueOf(1100).divide(new BigDecimal("1").add(new BigDecimal(20).divide(new BigDecimal("100"))), 2, BigDecimal.ROUND_DOWN).toString();
        //System.out.println(string);
        //for (int i = 0; i < 10; i++) {
        //    int a = getfeibonaALong(i);
        //    System.out.printf("Fibonacci of %d is: %d \n", i, a);
        //}
        //double weight = 10.0;
        //double decayedWeight = decayWeight(weight);
        //System.out.println(decayedWeight);
        //DateTime offset = DateUtil.offset(new Date(), DateField.DAY_OF_YEAR, -3);
        //System.out.println(offset);
        int hour = DateUtil.hour(new Date(), true);
        Double aDouble = Double.valueOf(null);
        System.out.println(aDouble);

    }

    public static int getfeibonaALong(int number) {

        if (number == 0 || number == 1) {
            return number;
        }
        return getfeibonaALong(number - 1) + getfeibonaALong(number - 2);

    }

    public static double decayWeight(double weight) {
        int numDecays = (int) (Math.log(0.001 / weight) / Math.log(0.5));
        double decayedWeight = weight * Math.pow(0.5, numDecays);
        return decayedWeight;
    }

}
