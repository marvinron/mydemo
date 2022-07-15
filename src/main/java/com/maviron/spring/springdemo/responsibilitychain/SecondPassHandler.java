package com.maviron.spring.springdemo.responsibilitychain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName SecondPassHandler.java
 * @Description 责任链模式的第二个处理者
 * @createTime 2022年07月04日 10:27:00
 */
public class SecondPassHandler extends AbstractHandler {

    private int getScore() {
        return 90;
    }

    @Override
    public int handler() {
        System.out.println("第二关的SecondPassHandler");
        int score = getScore();
        if (score >= 80) {
            if (this.next != null) {
                return this.next.handler();
            }

        }
        return score;
    }
}
