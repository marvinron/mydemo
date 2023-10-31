package com.maviron.spring.springdemo.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // Include.NON_NULL 属性为NULL 不序列化
        //ALWAYS // 默认策略，任何情况都执行序列化
        //NON_EMPTY // null、集合数组等没有内容、空字符串等，都不会被序列化
        //NON_DEFAULT // 如果字段是默认值，就不会被序列化
        //NON_ABSENT // null的不会序列化，但如果类型是AtomicReference，依然会被序列化
        MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        //取消默认转换timestamps形式
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //Date、Calendar等序列化为时间格式的字符串(如果不执行以下设置，就会序列化成时间戳格式)：
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss.SSS z
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
        //GMT+8
        //map.put("CTT", "Asia/Shanghai");
        MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 注册java新时间类型模块
        MAPPER.registerModule(new JavaTimeModule());

        //忽略空Bean转json的错误
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //空对象不要抛出异常：
        MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //反序列化时，遇到未知属性不要抛出异常：
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        //允许字段名没有引号（可以进一步减小json体积）：
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //允许单引号：
        MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 允许出现特殊字符和转义符
        MAPPER.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);

        //允许C和C++样式注释：
        MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

        //序列化结果格式化，美化输出
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);

        //枚举输出成字符串
        //WRITE_ENUMS_USING_INDEX：输出索引
        MAPPER.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

        //反序列化时，遇到忽略属性不要抛出异常：
        MAPPER.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

        //反序列化时，空字符串对于的实例属性为null：
        MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        //反序列化时，下划线驼峰转
        MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    }

    public static String objectToJson(Object obj) {
        try {
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            return MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("Parse object to String error: {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        if (null == clazz || StringUtils.isEmpty(json)) {
            return null;
        }
        if (String.class.equals(clazz)) {
            return (T) json;
        }
        try {
            return MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            log.error("LogMessage.MSG_02");
            throw new RuntimeException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T bytesToObject(byte[] bytes, Class<T> clazz) {
        if (null == clazz || null == bytes || bytes.length < 1) {
            return null;
        }
        try {
            return MAPPER.readValue(bytes, clazz);
        } catch (Exception e) {
            log.error("LogMessage.MSG_02_1");
            throw new RuntimeException(e.getMessage());
        }
    }

    public JsonNode readTree(String json) {
        try {
            return MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            log.error("LogMessage.MSG_03");
            throw new RuntimeException(e.getMessage());
        }
    }

    public JsonNode getChildrenFromJson(String json, String fieldName) {
        JsonNode parent = readTree(json);
        return null == parent ? null : parent.get(fieldName);
    }

    public JsonNode getChildrenFromNode(JsonNode jsonNode, String fieldName) {
        if (null == jsonNode || StringUtils.isBlank(fieldName)) {
            return null;
        }
        return jsonNode.get(fieldName);
    }

    public static <T> List<T> jsonToList(String json, Class<T> javaClazz) {
        if (null == json) {
            return new ArrayList<>();
        }
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, javaClazz);
            return MAPPER.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            log.error("error", e);
            return null;
        }
    }

    /**
     * json转集合
     *
     * @param <T>
     * @param json
     * @param typeReference <li>new TypeReference<List<User>>() {}</li>
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T toCollection(String json, TypeReference<T> typeReference) {
        try {
            if (StringUtils.isEmpty(json) || typeReference == null) {
                return null;
            }
            if (typeReference.getType().equals(String.class)) {
                return (T) json;
            }
            return MAPPER.readValue(json, typeReference);
        } catch (IOException e) {
            log.error("Parse String to Bean error", e);
            return null;
        }
    }

    public static <K, V> Map<K, V> jsonToMap(String json, Class<K> keyClass, Class<V> valueClass) {
        try {
            return MAPPER.readValue(json,
                MAPPER.getTypeFactory().constructParametricType(Map.class, keyClass, valueClass));
        } catch (JsonProcessingException e) {
            log.error("error", e);
        }
        return Collections.emptyMap();
    }

    /**
     * 读取磁盘的json文件，转换成json对象
     */
    public static JsonNode readJsonFile(String jsonPath) {
        if (StringUtils.isEmpty(jsonPath)) {
            log.error("JsonPath is empty.");
            return null;
        }
        try {
            return MAPPER.readTree(FileUtils.getFile(jsonPath));
        } catch (IOException e) {
            log.error("ReadJson from File[{}] failed, exception is {}", jsonPath, e.getLocalizedMessage());
        }
        return null;
    }
}