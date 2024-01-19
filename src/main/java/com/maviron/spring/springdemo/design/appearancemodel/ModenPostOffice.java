package com.maviron.spring.springdemo.design.appearancemodel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ModenPostOffice.java
 * @Description TODO
 * @createTime 2024年01月19日 09:50:00
 */
public class ModenPostOffice {

    private ILetterProcess letterProcess = new LetterProcessImpl();
    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);
        letterProcess.letterInotoEnvelope();
        letterProcess.sendLetter();
    }
}
