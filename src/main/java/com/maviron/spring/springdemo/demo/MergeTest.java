package com.maviron.spring.springdemo.demo;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * TODO
 *
 * @author shijiaoming
 * @version 1.0.0
 * @since 2023/09/18 19:31
 */
public class MergeTest {

    public static void main(String[] args) {

        deserialized();
//        extracted1();
//        extracted();


    }

    private static void deserialized(){
        String msg = "{\"rtb_id\":\"aa\"}";
        //EventDTO dto = JSONObject.parseObject(msg, EventDTO.class);
        EventDTO dto = JsonUtil.bytesToObject(msg.getBytes(StandardCharsets.UTF_8), EventDTO.class);
        System.out.println(dto);
    }


    private static void extracted() {
        // 请求响应消息
        String[] reqColumn = new String[]{"","req 广告位","","req 媒体 ID","","","","","",""};
        String[] respColumn = new String[]{"","resp 广告位","","","","","","","resp 填充价格 19.5",""};

        // 请求有值字段
        BitSet req = new BitSet(10);
        req.set(1);
        req.set(3);
        req.set(8);

        // 响应有值字段
        BitSet resp = new BitSet(10);
        resp.set(1);
        resp.set(8);

        // 响应替换请求
        req.andNot(resp);

        // 测试输出取出的字段
        Set<String> reqVal = req.stream().mapToObj(idx -> reqColumn[idx]).collect(Collectors.toSet());
        Set<String> respVal = resp.stream().mapToObj(idx -> respColumn[idx]).collect(Collectors.toSet());
        reqVal.addAll(respVal);
        System.out.println(reqVal);
    }


}
