package com.maviron.spring.springdemo.design.appearancemodel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName LetterProcessImpl.java
 * @Description TODO
 * @createTime 2024年01月19日 09:45:00
 */
public class LetterProcessImpl implements ILetterProcess {
    @Override
    public void writeContext(String context) {
        System.out.println("写信内容");
    }

    @Override
    public void fillEnvelope(String address) {
        System.out.println("填写收信人地址和姓名");
    }

    @Override
    public void letterInotoEnvelope() {
        System.out.println("把信放到信封里");
    }

    @Override
    public void sendLetter() {
        System.out.println("寄出去");
    }
}
