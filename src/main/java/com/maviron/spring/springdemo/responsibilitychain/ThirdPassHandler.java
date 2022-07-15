package com.maviron.spring.springdemo.responsibilitychain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.omg.SendingContext.RunTime;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ThirdPassHandler.java
 * @Description TODO
 * @createTime 2022年07月04日 10:31:00
 */
public class ThirdPassHandler extends AbstractHandler {

    private int getScore() {
        return 95;
    }

    @Override
    public int handler() {
        System.out.println("进入第三关：ThirdPassHandler");
        int score = getScore();
        if(score >= 90){
            if(this.next != null){
                return this.next.handler();
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("执行了addShutdownHook的方法进行退出")));
        System.out.println("退出了main的方法！");
    }



}
