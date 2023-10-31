package com.maviron.spring.springdemo.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.StopWatch;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EntityTest.java
 * @Description 测试用的实体类
 * @createTime 2022年10月11日 15:21:00
 */
public class EntityTest implements Serializable {
    private static final long serialVersionUID = 5267145989015295486L;
    /**
     * 日期
     */
    @JSONField(name = "日期")
    private String dt;
    /**
     * 留存天数
     */
    private String retentionDay;
    /**
     * 留存数量
     */
    private String retentionCount;
    /**
     * 新用户数
     */
    private String newUserCount;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getRetentionDay() {
        return retentionDay;
    }

    public void setRetentionDay(String retentionDay) {
        this.retentionDay = retentionDay;
    }

    public String getRetentionCount() {
        return retentionCount;
    }

    public void setRetentionCount(String retentionCount) {
        this.retentionCount = retentionCount;
    }

    public String getNewUserCount() {
        return newUserCount;
    }

    public void setNewUserCount(String newUserCount) {
        this.newUserCount = newUserCount;
    }

    public int getRetentionIntValue() {
        return 0;
    }

    @Override
    public String toString() {
        return "EntityTest{" +
                "dt='" + dt + '\'' +
                ", retentionDay='" + retentionDay + '\'' +
                ", retentionCount='" + retentionCount + '\'' +
                ", newUserCount='" + newUserCount + '\'' +
                '}';
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //List<EntityTest> list = new ArrayList<>();
        //EntityTest entityTest1 = new EntityTest();
        //entityTest1.setDt("1");
        //entityTest1.setNewUserCount("200");
        //entityTest1.setRetentionCount("300");
        //EntityTest entityTest2 = new EntityTest();
        //entityTest2.setDt("1");
        //entityTest2.setNewUserCount("200");
        //entityTest2.setRetentionCount("300");
        //EntityTest entityTest3 = new EntityTest();
        //entityTest3.setDt("1");
        //entityTest3.setNewUserCount("200");
        //entityTest3.setRetentionCount("300");
        //list.add(entityTest1);
        //list.add(entityTest2);
        //list.add(entityTest3);
        //System.out.println(JSON.toJSONString(list));
        //DateTime truncate = DateUtil.truncate(new Date(), DateField.HOUR);
        //System.out.println(truncate);
        //Object s = DateUtil.offsetHour(new Date(), -1).hour(true);
        //DateTime yyyyMMddHH = DateUtil.parse("2022120712", "yyyyMMddHH");
        //String s1 = yyyyMMddHH.toDateStr();
        //System.out.println(s1);
        //System.out.println(s);
        //String dateTime = DateUtil.format(DateUtil.offsetHour(new Date(), -1),"yyyyMMddHH");
        //
        //System.out.println(dateTime);
        //
        //List<Integer> integers = CollectionUtil.newArrayList(1,2,3,4);
        //System.out.println(integers);
        //Collections.shuffle(integers);
        //System.out.println(integers);
        //List<Integer> list1 = CollectionUtil.removeAny(integers, 2);
        //System.out.println(list1);
        //EntityTest entityTest = new EntityTest();
        //Field[] fields = entityTest.getClass().getDeclaredFields();
        //for (Field field : fields) {
        //    JSONField annotation = field.getAnnotation(JSONField.class);
        //    if(Objects.isNull(annotation)){
        //        continue;
        //    }
        //    String name = annotation.name();
        //    System.out.println(name);
        //}
        //entityTest.setDt("12313");
        //String string = JSONObject.toJSONString(entityTest);
        //stopWatch.stop();
        //System.out.println(string);
        //Stream.Builder<Object> builder = Stream.builder();
        //builder.add("123");
        //builder.add("124");
        //builder.add("125");
        //builder.add("126");
        //List<Object> collect = builder.build().collect(Collectors.toList());
        //System.out.println(collect);
        //Path path = Paths.get("123.txt");
        //try (Stream<String> stream = Files.lines(path)) {
        //    // 使用 stream 处理数据
        //    stream.forEach(s->System.out.println(s));
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        Stream<Integer> flattenedStream = nestedList.stream().flatMap(List::stream);
        Optional<Integer> max = flattenedStream.max(Comparator.comparing(e -> e.intValue()));
        Integer integer = max.get();
        System.out.println(integer);
        //List<Integer> collect = flattenedStream.collect(Collectors.toList());
        //System.out.println(collect);
    }
}
