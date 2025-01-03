package com.maviron.spring.springdemo.until;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cube.li
 * @date 2021/9/4 10:46
 * @description Jackson工具类
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class
JacksonUtils {

    private final static JavaType OBJECT_MAP_TYPE;
    private final static JavaType MAP_LIST_TYPE;
    private final static ObjectMapper JSON_MAPPER;

    static {
        JSON_MAPPER = new ObjectMapper();
        OBJECT_MAP_TYPE = getJavaType(Map.class, String.class, Object.class);
        MAP_LIST_TYPE = getJavaType(List.class, OBJECT_MAP_TYPE);
    }

    /**
     * 转为 Json字符串
     *
     * @param o 目标对象
     * @return Json字符串
     */
    public static String toJsonString(Object o) throws JsonProcessingException {
        return JSON_MAPPER.writeValueAsString(o);
    }

    /**
     * 转为指定对象
     *
     * @param object 目标对象
     * @param clazz  转换类型
     * @param <T>    转换类型
     * @return 转换类型对象
     */
    public static <T> T toJavaObject(Object object, Class<T> clazz) {
        return JSON_MAPPER.convertValue(object, clazz);
    }

    /**
     * 转为指定对象
     *
     * @param object   目标对象
     * @param javaType 转换类型
     * @param <T>      转换类型
     * @return 转换类型对象
     */
    public static <T> T toJavaObject(Object object, JavaType javaType) {
        return JSON_MAPPER.convertValue(object, javaType);
    }

    /**
     * 转为 泛型集合
     *
     * @param o         目标对象
     * @param listClass 集合类型
     * @param <T>       集合类型
     * @return 泛型集合
     */
    public static <T> List<T> toJavaList(Object o, Class<T> listClass) {
        JavaType javaType = getJavaType(ArrayList.class, listClass);
        return JSON_MAPPER.convertValue(o, javaType);
    }

    /**
     * 转为 泛型集合
     *
     * @param o 目标对象
     * @return 泛型集合
     */
    public static List<Map<String, Object>> toMapList(Object o) {
        return JSON_MAPPER.convertValue(o, MAP_LIST_TYPE);
    }

    /**
     * 转为 Map&lt;String,Object&gt;对象
     *
     * @param o 目标对象
     * @return Map对象
     */
    public static Map<String, Object> toMap(Object o) {
        return JSON_MAPPER.convertValue(o, OBJECT_MAP_TYPE);
    }

    /**
     * 转为 Map&lt;String,Object&gt;对象
     *
     * @param jsonString jason字符串
     * @return Map对象
     */
    public static Map<String, Object> toMap(String jsonString) throws JsonProcessingException {
        return JSON_MAPPER.readValue(jsonString, OBJECT_MAP_TYPE);
    }

    /**
     * 转为 List
     *
     * @param o 目标对象
     * @return List对象
     */
    public static List<Object> toJavaList(Object o) {
        return toJavaList(o, Object.class);
    }

    /**
     * 转换
     *
     * @param o        原始对象
     * @param javaType 类型
     * @param <T>      结果类型
     */
    public static <T> T convert(Object o, JavaType javaType) {
        return JSON_MAPPER.convertValue(o, javaType);
    }

    /**
     * 类型
     *
     * @param collectionClass 主类型类型
     * @param elementClasses  泛型型
     * @return javaType对象
     */
    public static JavaType getJavaType(Class<?> collectionClass, Class<?>... elementClasses) {
        return JSON_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 类型
     *
     * @param collectionClass  主类型类型
     * @param elementJavaTypes 泛型型
     * @return javaType对象
     */
    public static JavaType getJavaType(Class<?> collectionClass, JavaType... elementJavaTypes) {
        return JSON_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementJavaTypes);
    }

    /**
     * 获取JavaType
     */
    public static JavaType getJavaType(Class<?> clazz) {
        return JSON_MAPPER.getTypeFactory().constructType(clazz);
    }

    public static <T> T readJsonString(String jsonString, Class<T> clazz) {
        try {
            return JSON_MAPPER.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * jsonString 读取为java对象
     *
     * @param jsonString jsonString
     * @param javaType   目标类型
     * @param <T>        目标类型
     * @return 目标对象
     */
    public static <T> T readJsonString(String jsonString, JavaType javaType) {
        try {
            return JSON_MAPPER.readValue(jsonString, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * jsonString 读取为java对象
     *
     * @param jsonString    jsonString
     * @param typeReference 目标类型
     * @param <T>           目标类型
     * @return 目标对象
     */
    public static <T> T readJsonString(String jsonString, TypeReference<T> typeReference) {
        try {
            return JSON_MAPPER.readValue(jsonString, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
