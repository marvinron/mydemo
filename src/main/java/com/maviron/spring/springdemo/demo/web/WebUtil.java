package com.maviron.spring.springdemo.demo.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.function.Predicate;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName WebUtil.java
 * @Description TODO
 * @createTime 2021年12月21日 10:11:00
 */
public class WebUtil extends WebUtils {
    private static final Logger log = LoggerFactory.getLogger(WebUtil.class);
    public static final String USER_AGENT_HEADER = "user-agent";
    private static final String[] IP_HEADER_NAMES = new String[]{"x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
    private static final Predicate<String> IP_PREDICATE = (ip)->{return StringUtils.isEmpty(ip)|| "unknown".equalsIgnoreCase(ip);};

    public WebUtil() {
    }

    public static boolean isbody(HandlerMethod handlerMethod){
        ResponseBody annotation = (ResponseBody)ClassUtil.getAnnotation(handlerMethod.getMethod(), ResponseBody.class);
        return annotation != null;
    }
    public static String getCookieValue(String name){
        HttpServletRequest request = getRequest();
        Cookie cookie = getCookie(request, name);
        return cookie != null?cookie.getValue() : null;
    }
    public static void removeCookie(HttpServletResponse response,String name){
        setCookie(response,name,null,0);
    }

    public static void setCookie(HttpServletResponse response, String name,String value,int maxSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxSeconds);
        cookie.setValue(value);
        response.addCookie(cookie);
    }

    public String getIp(){
        String ip = "";
        HttpServletRequest request = getRequest();
        if(request == null){
            return "";
        }
        for (int i = 0; i < IP_HEADER_NAMES.length; i++) {
            ip = request.getHeader(IP_HEADER_NAMES[i]);
            if(IP_PREDICATE.test(ip)){
                ip = request.getRemoteAddr();
            }
        }
        return ip;

    }


public static HttpServletRequest getRequest() {
    ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    return requestAttributes.getRequest();
}














}
