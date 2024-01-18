package com.maviron.spring.springdemo.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.StopWatch;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.util.JsonFormat;
import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.proto.DemoProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName DemoProtoController.java
 * @Description TODO
 * @createTime 2023年02月06日 15:59:00
 */
@Controller
@RequestMapping("/test")
public class DemoProtoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "proto")
    @ResponseBody
    public void testProto(HttpServletRequest request, HttpServletResponse response,@RequestBody byte[] pbData) throws Exception {
        DemoProto.Demo demo = DemoProto.Demo.parseFrom(request.getInputStream());
        DemoProto.Demo qwewq = demo.toBuilder().setName("12321").setCode("qwewq").build();
        String print = JsonFormat.printer().print(qwewq);
        //HttpHeaders headers = new HttpHeaders();
        String string = DemoProto.Demo.parseFrom(pbData).toString();
        System.out.println(string);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        qwewq.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping(value = "protoBody")
    @ResponseBody
    public DemoProto.Demo testprotoBody(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DemoProto.Demo demo = DemoProto.Demo.parseFrom(request.getInputStream());
        DemoProto.Demo qwewq = demo.toBuilder().setName("12321").setCode("qwewq").build();
        //String print = JsonFormat.printer().print(qwewq);
        ////HttpHeaders headers = new HttpHeaders();
        //response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        //ServletOutputStream outputStream = response.getOutputStream();
        //qwewq.writeTo(outputStream);
        //outputStream.flush();
        //outputStream.close();
        return qwewq;
    }

    @RequestMapping(value = "proto/desc")
    @ResponseBody
    public String descProto(HttpServletRequest request, String key) throws Exception {
        String s = new String(Base64.getDecoder().decode(key.getBytes()));
        return s;

    }

    @RequestMapping(value = "proto/byte")
    @ResponseBody
    public byte[] testProtoByte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DemoProto.Demo demo = DemoProto.Demo.parseFrom(request.getInputStream());
        DemoProto.Demo qwewq = demo.toBuilder().setName("12321").setCode("qwewq").build();
        String print = JsonFormat.printer().print(qwewq);
        int length = qwewq.toByteArray().length;
        int length1 = Base64.getEncoder().encodeToString(qwewq.toByteArray()).length();
        Date date = new Date();
        return qwewq.toByteArray();
    }

    @RequestMapping(value = "proto/testNormal")
    public void testNormal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        user.setId("1");
        user.setName("adas");
        user.setAge(12);
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = response.getWriter();
        writer.write(JSONObject.toJSONString(user));
        writer.flush();
        writer.close();

    }

    @RequestMapping("getPror")
    public String getPror() {

        DemoProto.Demo obj = this.restTemplate.getForObject("http://127.0.0.1:8080/test/proto",
                DemoProto.Demo.class);
        return obj.toString();
    }

    @RequestMapping("requestPror")
    @ResponseBody
    public String requestPror() throws Exception {
        DemoProto.Demo.Builder builder = DemoProto.Demo.newBuilder();
        DemoProto.Demo qwewqewqe = builder.setId(8888).setName("qwewqewqe").setCode("865545343").build();
        byte[] bytes = this.restTemplate.postForObject("http://127.0.0.1:8080/test/proto", qwewqewqe.toByteArray(),
                byte[].class);
        return DemoProto.Demo.parseFrom(bytes).toString();
    }

    @RequestMapping("requestNormal")
    @ResponseBody
    public String requestNormal() throws Exception {
        User user = new User();
        user.setId("00001");
        user.setName("qpqpqpqp");
        User obj = this.restTemplate.postForObject("http://127.0.0.1:8080/test/proto/testNormal", user,
                User.class);
        return JSONObject.toJSONString(obj);
    }

    @RequestMapping("requestByte")
    @ResponseBody
    public String requestByte() throws Exception {
        DemoProto.Demo.Builder builder = DemoProto.Demo.newBuilder();
        DemoProto.Demo qwewqewqe = builder.setId(8888).setName("qwewqewqe").setCode("865545343").build();
        byte[] bytes = this.restTemplate.postForObject("http://127.0.0.1:8080/test/proto/byte", qwewqewqe.toByteArray(),
                byte[].class);
        System.out.println(bytes instanceof byte[]);
        return DemoProto.Demo.parseFrom(bytes).toString();
    }
    @RequestMapping("requestEntity")
    @ResponseBody
    public String requestEntity() throws Exception {
        DemoProto.Demo.Builder builder = DemoProto.Demo.newBuilder();
        DemoProto.Demo qwewqewqe = builder.setId(8888).setName("qwewqewqe").setCode("865545343").build();
        ResponseEntity<DemoProto.Demo> demoResponseEntity = this.restTemplate.postForEntity("http://127.0.0.1:8080/test/protoBody", qwewqewqe,
                DemoProto.Demo.class);
        return demoResponseEntity.getBody().toString();
    }
}
