package com.maviron.spring.springdemo.test;

import com.alibaba.fastjson.JSON;
import com.maviron.spring.springdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
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

        List<String> list = new ArrayList<>();
        list.add("00001");
        list.add("00004");
        list.add("00007");
        list.add("00010");
        list.add("00013");

    }
}
