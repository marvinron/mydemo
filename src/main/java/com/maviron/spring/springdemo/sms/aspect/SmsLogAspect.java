package com.maviron.spring.springdemo.sms.aspect;

import com.maviron.spring.springdemo.sms.constant.SmsInfo;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SmsLogAspect.java
 * @Description SmsLogAspect
 * @createTime 2022年05月11日 18:14:00
 */
@Aspect
@Component
public class SmsLogAspect {
    Logger logger = Logger.getLogger("SmsLogAspect");

    @Pointcut("@annotation(com.maviron.spring.springdemo.sms.aspect.SmsLog)")
    public void pointcut() {

    }

    @AfterReturning(pointcut = "pointcut()", returning = "result")
    public void handleReturn(Object result) {

    }
}
