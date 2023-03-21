package com.maviron.spring.springdemo.aspringexpand.propertySourceLoaderexpend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName JsonPropertySourceLoader.java
 * @Description 增加JSOn的property处理
 * @createTime 2023年03月16日 18:59:00
 */
public class JsonPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"json"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        ReadableByteChannel readableByteChannel = resource.readableChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) resource.contentLength());
        readableByteChannel.read(byteBuffer);
        //将读出来的数据放到ByteBuffer中
        String content = new String(byteBuffer.array());
        //将字符串转换为JSONObject
        JSONObject json = JSONObject.parseObject(content);
        Map<String, Object> map = new HashMap<>(json.size());
        //将JSOn的键值对读出来 放入到map中
        for (String key : json.keySet()) {
            map.put(key, json.get(key));
        }
        return Collections.singletonList(new MapPropertySource("jsonPropertySource", map));
    }
}
