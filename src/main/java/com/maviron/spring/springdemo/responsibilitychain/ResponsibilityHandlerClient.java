package com.maviron.spring.springdemo.responsibilitychain;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ResponsibilityHandlerClient.java
 * @Description 责任链的处理类
 * @createTime 2022年07月04日 10:42:00
 */
public class ResponsibilityHandlerClient {
    public static void main(String[] args) {
        FirstPassHandler firstPassHandler = new FirstPassHandler();
        SecondPassHandler secondPassHandler = new SecondPassHandler();
        ThirdPassHandler thirdPassHandler = new ThirdPassHandler();
        firstPassHandler.setNext(secondPassHandler);
        secondPassHandler.setNext(thirdPassHandler);
        firstPassHandler.handler();
        //String inputJson = "{\"front\":[{\"timeNo\":1,\"timeRange\":[0,1,2,3,5,6,7,8,9,10,11,4,13,12,14,15],\"timeData\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123}},{\"timeNo\":2,\"timeRange\":[16,17,18,19,20,21,22,23],\"timeData\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123}}],\"back\":{\"0\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"1\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"2\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"3\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"4\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"5\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"6\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"7\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"8\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"9\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"10\":{\"adxRtbPriceYuan\":123.01,\"rtbMinimumPriceYuan\":12.3,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"11\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"12\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"13\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"14\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"15\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":123,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"16\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"17\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"18\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"19\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"20\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"21\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"22\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123},\"23\":{\"adxRtbPriceYuan\":123,\"rtbMinimumPriceYuan\":23,\"dealChargeType\":1,\"settlementPriceYuan\":123}}}";
        //JSONObject jsonObject = JSONObject.parseObject(inputJson);
        //JSONObject backJson = jsonObject.getJSONObject("back");
        ////获取对应的小时的json
        //String nowHour = String.valueOf(DateUtil.hour(new Date(), true));
        //JSONObject hourJson = backJson.getJSONObject(nowHour);
        //
        //Map<String, String> map = JSONObject.parseObject(JSONObject.toJSONString(hourJson), Map.class);
        //System.out.println(map);
        //String str = "0";
        //Double s = StringUtils.isNotBlank(str) ? Double.valueOf(str)  : null;
        //Double aDouble = Optional.ofNullable("").map(Double::valueOf).orElse(null);
        //System.out.println(s);
    }
}
