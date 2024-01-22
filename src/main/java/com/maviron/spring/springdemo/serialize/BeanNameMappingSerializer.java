package com.maviron.spring.springdemo.serialize;

import cn.hutool.core.collection.CollectionUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class BeanNameMappingSerializer extends JsonSerializer<Object> {
    private static final long serialVersionUID = 29L;

    @Override
    public void serialize(Object bean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        Class<?> beanClass = bean.getClass();
        JsonSerialize jsonSerializeAnn = AnnotationUtils.findAnnotation(beanClass, JsonSerialize.class);
        Class<? extends JsonSerializer> using = jsonSerializeAnn.using();
        if (BeanNameMappingSerializer.class != using){
            throw new IllegalArgumentException("BeanNameMappingSerializer can only be used with @JsonSerialize(using=BeanNameMappingSerializer.class)");
        }

        String cacheKey = getCacheKey(bean, beanClass);
        jsonGenerator.writeStartObject();
        List<BeanPropertyDefinition> properties = getBeanProperties(beanClass,serializerProvider);
        for (BeanPropertyDefinition property : properties) {
            AnnotatedMember annotatedMember = property.getAccessor();
            JsonIgnore annotation = annotatedMember.getAnnotation(JsonIgnore.class);
            if (annotation!=null){continue;}
            if (property.hasGetter()) {
                Method method = ReflectionUtils.findMethod(beanClass, property.getGetter().getName());
                Object result = ReflectionUtils.invokeMethod(method, bean);
                jsonGenerator.writeStringField(getMappingName(cacheKey,property.getName())
                                              ,result!=null?result.toString():null);
            }
        }
        jsonGenerator.writeEndObject();
    }

    private List<BeanPropertyDefinition> getBeanProperties(Class<?> beanClass,SerializerProvider serializerProvider) {
        JavaType javaType = TypeFactory.defaultInstance().constructType(beanClass);
        BeanDescription beanDescription = serializerProvider.getConfig().introspect(javaType);
        List<BeanPropertyDefinition> properties = beanDescription.findProperties();
        return properties;
    }

    /**
     * 目前就参数对比使用，不再进行扩展开发
     * @param bean
     * @return
     */
    private String getCacheKey(Object bean,Class<?> beanClass){
        Field mediaId = ReflectionUtils.findField(beanClass, "accountNo");
        if (null != mediaId){
            ReflectionUtils.makeAccessible(mediaId);
            Object field = ReflectionUtils.getField(mediaId, bean);
            return field!=null?field.toString():"";
        }
        return "";
    }

    /**
     * 获取映射的字段名
     * @param key
     * @param name
     * @return
     */
    private String getMappingName(String key,String name){
        //key如果是空不去查询缓存
        if (StringUtils.isBlank(key)){
            return name;
        }
        if(NameMappingCache.isEmpty()){
            NameMappingCache.putMediaMapping();
        }
        Map<String, String> mapping = NameMappingCache.getUnchecked(key);
        if (CollectionUtil.isNotEmpty(mapping)){
            String mappingName = mapping.get(name);
            name = mappingName!=null? mappingName:name;
        }
        return name;
    }
}