package com.maviron.spring.springdemo.responsibilitychain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ResponsibilityHandlerClient.java
 * @Description 责任链的处理类
 * @createTime 2022年07月04日 10:42:00
 */
public class ResponsibilityHandlerClient {
    public static void main(String[] args) {
        FirstPassHandler firstPassHandler = new FirstPassHandler();
        SecondPassHandler secondPassHandler = new SecondPassHandler();
        ThirdPassHandler thirdPassHandler = new ThirdPassHandler();
        firstPassHandler.setNext(secondPassHandler);
        secondPassHandler.setNext(thirdPassHandler);
        firstPassHandler.handler();
    }
}
