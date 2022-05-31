package com.maviron.spring.springdemo.demo.config;

import com.maviron.spring.springdemo.demo.annotation.SystemCrmlog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SystemLogAspect.java
 * @Description TODO
 * @createTime 2021年12月21日 09:58:00
 */
@Component
@Aspect
public class SystemLogAspect {
    @Pointcut("@annotation(com.maviron.spring.springdemo.demo.annotation.SystemCrmlog)")
    public void crmAspect() {
    }

    @AfterThrowing(value = "crmAspect()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        HttpServletRequest request = getRequest();
        MethodSignature methodSignature =
                (MethodSignature) joinPoint.getSignature();

        //获得连接点的原始方法
        Method method = methodSignature.getMethod();

        SystemCrmlog annotation = method.getAnnotation(SystemCrmlog.class);
        System.out.println(annotation.description());


    }

    public HttpServletRequest getRequest() {
        RequestAttributes requestAttributes =
                RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        List<String> list = new ArrayList();
        return servletRequestAttributes.getRequest();
    }


}
