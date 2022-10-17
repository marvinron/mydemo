package com.maviron.spring.springdemo.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestMain.java
 * @Description TODO
 * @createTime 2022年10月11日 15:29:00
 */
public class TestMain {
    public static void main(String[] args) {
        List<EntityTest> entities = new ArrayList<>();

        EntityTest entity20 = new EntityTest();
        entity20.setDt("2022-09-20");
        entity20.setRetentionDay("0");
        entity20.setRetentionCount("0");
        entity20.setNewUserCount("30");
        entities.add(entity20);

        EntityTest entity = new EntityTest();
        entity.setDt("2022-09-20");
        entity.setRetentionDay("1");
        entity.setRetentionCount("20");
        entity.setNewUserCount("0");
        EntityTest entity1 = new EntityTest();
        entity1.setDt("2022-09-20");
        entity1.setRetentionDay("2");
        entity1.setRetentionCount("18");
        entity1.setNewUserCount("0");
        EntityTest entity2 = new EntityTest();
        entity2.setDt("2022-09-20");
        entity2.setRetentionDay("3");
        entity2.setRetentionCount("15");
        entity2.setNewUserCount("0");
        EntityTest entity3 = new EntityTest();
        entity3.setDt("2022-09-21");
        entity3.setRetentionDay("1");
        entity3.setRetentionCount("12");
        entity3.setNewUserCount("20");
        EntityTest entity4 = new EntityTest();
        entity4.setDt("2022-09-21");
        entity4.setRetentionDay("2");
        entity4.setRetentionCount("10");
        entity4.setNewUserCount("20");
        entities.add(entity1);
        entities.add(entity2);
        entities.add(entity);
        entities.add(entity3);
        entities.add(entity4);
        System.out.println(entities);
        //Map<String, List<EntityTest>> entitiesMap = entities.stream()
        //        .collect(Collectors.groupingBy(EntityTest::getDt, LinkedHashMap::new, Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), li -> {
        //            li.sort(Comparator.comparing(EntityTest::getRetentionIntValue).reversed());
        //            return li;
        //        })));

        Map<String, List<EntityTest>> entitiesMap = entities.stream()
                .collect(Collectors.groupingBy(EntityTest::getDt, LinkedHashMap::new, Collectors.toList()));
        System.out.println(entitiesMap);
        JSONArray jsonArray = new JSONArray();
        entitiesMap.forEach((k, v) -> {
            JSONObject json = new JSONObject();
            json.put("dt", k);
            v.forEach(en -> {
                if (StringUtils.equals(en.getRetentionDay(), "0")) {
                    json.put("0", en.getNewUserCount());
                } else {
                    json.put(en.getRetentionDay(), en.getRetentionCount());
                }
            });
            jsonArray.add(json);
        });
        System.out.println(jsonArray);


    }
}
