package com.maviron.spring.springdemo.responsibilitychain;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName FirstPassHandler.java
 * @Description 第一个责任链的处理器
 * @createTime 2022年07月04日 10:05:00
 */
public class FirstPassHandler extends AbstractHandler {

    private int play() {
        return 80;
    }

    @Override
    public int handler() {
        System.out.println("第一关处理类：FirstPassHandler");
        int score = play();
        if (score >= 80) {
            //分数大于并且存在下一关
            if (this.next != null) {
                return this.next.handler();
            }
        }
        return score;
    }
}
