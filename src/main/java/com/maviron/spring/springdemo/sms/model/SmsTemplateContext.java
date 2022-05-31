package com.maviron.spring.springdemo.sms.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.maviron.spring.springdemo.sms.constant.SmsConstant;
import com.maviron.spring.springdemo.until.PlaceHolderUtils;
import lombok.Data;

import java.util.Set;

/**
 * SmsTemplateContext 模板上下文
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SmsTemplateContext {

    /**
     * 模板主键id
     */
    private Long templateId;

    /**
     * 模板code
     */
    private Integer templateCode;

    /**
     * 模板分类
     */
    private Integer templateClassify;

    /**
     * 模板内容
     */
    private String templateContent;

    /**
     * 占位符: 前缀 + key + 后缀,例如 {url}
     * 占位符key集合
     */
    private Set<String> placeHolderKeySet;

    public static SmsTemplateContext from(String templateContent, Integer templateCode) {
        SmsTemplateContext context = new SmsTemplateContext();
        context.setTemplateContent(templateContent);
        context.setTemplateCode(templateCode);
        context.setPlaceHolderKeySet(PlaceHolderUtils.getPlaceHolderKeySet(templateContent, SmsConstant.DEFAULT_PLACE_HOLDER_REGEX, SmsConstant.DEFAULT_PLACE_HOLDER_KEY_REGEX));
        return context;
    }

    public int getPlaceHolderKeyCount() {
        return this.placeHolderKeySet.size();
    }

}
