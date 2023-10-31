package com.maviron.spring.springdemo.test;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.entity.UserVo;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyTest.java
 * @Description TODO
 * @createTime 2023年09月07日 12:09:00
 */
public class MyTest {
    public static void main(String[] args) {
        //Map<String,User> map = new HashMap<String,User>();
        //User user1 = new User();
        //user1.setSalery(11.0);
        //map.put("123213",user1);
        //User user = new User();
        //user.setName("测试");
        //user.setAge(18);
        //UserVo userVo = new UserVo();
        //userVo.setEmail("123213");
        //userVo.setAge(20);
        //user.setUserVo(userVo);
        //Double aDouble = Optional.ofNullable(user.getUserVo()).map(UserVo::getEmail)
        //        .map(em -> map.get(em))
        //        .map(User::getSalery).orElse(null);
        //System.out.println(aDouble);
        //Double bidFloorYuan = 0.0000;
        //System.out.println(String.valueOf(bidFloorYuan));

        //DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
        //int newDayOfWeekValue = (dayOfWeek.getValue() % 7) + 1;
        //DayOfWeek newDayOfWeek = DayOfWeek.of(newDayOfWeekValue);
        //System.out.println(newDayOfWeek);
        //int dayOfWeekValue = 1;
        //int i = (dayOfWeekValue + 5) % 7 + 1;
        //System.out.println(i);
        String str = "[{\"week\":1,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]},{\"week\":2,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]},{\"week\":3,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]},{\"week\":4,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]},{\"week\":5,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]},{\"week\":6,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]},{\"week\":7,\"hour\":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23]}]";
        //JSONArray jsonArray = JSONObject.parseArray(str);
        //for (int i = 0; i < jsonArray.size(); i++) {
        //    JSONObject jsonObject = jsonArray.getJSONObject(i);
        //    JSONArray hourArray = jsonObject.getJSONArray("hour");
        //    System.out.println(hourArray.size());
        //}
        int remainingHourCount= 0;
        if (StringUtils.isBlank(str)) {
            remainingHourCount = 7 * 24;
        } else {
            JSONArray jsonArray = JSONObject.parseArray(str);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject hourJson = jsonArray.getJSONObject(i);
                JSONArray hourArray = hourJson.getJSONArray("hour");
                remainingHourCount += hourArray.size();
            }
        }
        System.out.println(remainingHourCount);
        int i = remainingHourCount * 60;

    }

    public static class Device {
        private String imei;
        private String oaid;

        public String getImei() {
            return imei;
        }

        public Device setImei(String imei) {
            this.imei = imei;
            return this;
        }

        public String getOaid() {
            return oaid;
        }

        public Device setOaid(String oaid) {
            this.oaid = oaid;
            return this;
        }
    }
}
