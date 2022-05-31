package com.maviron.spring.springdemo.sms.strategy;

import com.maviron.spring.springdemo.sms.model.SmsPlaceHolderParameter;
import com.maviron.spring.springdemo.sms.model.SmsTemplateContext;

import java.util.Set;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsSendAnyMatchStrategy.java
 * @Description SmsSendAnyMatchStrategy
 * @createTime 2022年05月11日 18:52:00
 */
public class SmsSendAnyMatchStrategy implements SmsSendRejectStrategy {
    @Override
    public void reject(SmsTemplateContext templateContext, SmsPlaceHolderParameter parameter) {
        Set<String> parameterKeySet = getParameterSet(parameter);

    }
}
