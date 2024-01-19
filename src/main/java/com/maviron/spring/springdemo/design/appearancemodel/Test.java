package com.maviron.spring.springdemo.design.appearancemodel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2024年01月19日 09:48:00
 */
public class Test {
    public static void main(String[] args) {
        //ILetterProcess letterProcess = new LetterProcessImpl();
        //letterProcess.writeContext("信的内容");
        //letterProcess.fillEnvelope("收件人联系方式和地址");
        //letterProcess.letterInotoEnvelope();
        //letterProcess.sendLetter();
        ModenPostOffice modenPostOffice = new ModenPostOffice();
        modenPostOffice.sendLetter("这是信的内容","这是收件人地址");
    }
}
