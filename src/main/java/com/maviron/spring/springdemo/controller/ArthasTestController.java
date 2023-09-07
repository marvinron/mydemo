package com.maviron.spring.springdemo.controller;

import cn.hutool.core.date.StopWatch;
import com.maviron.spring.springdemo.function.truefalsehandle.BranchHandleUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName ArthasTestController.java
 * @Description arthas测试
 * @createTime 2023年05月09日 12:21:00
 */
@RestController
@RequestMapping("/arthas")
public class ArthasTestController {

    @RequestMapping("test")
    public String test() throws Exception {
        //doMethodA();
        //doMethodB();
        //doMethodC();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        boolean flag = true;
        for (int i = 0; i < 100; i++) {
            BranchHandleUtil.doHandle(flag).trueOrFalseHandle(trueHandle(),falseHandle());
        }
        stopWatch.stop();
        System.out.println("耗费时长是："+stopWatch.getTotalTimeMillis());
        return "arthas 测试接口时间 ";
    }

    private void doMethodC() throws Exception{
        Thread.sleep(3000);
    }

    private void doMethodB() throws Exception {
        Thread.sleep(2000);

    }

    private void doMethodA() throws Exception {
        Thread.sleep(1000);
    }
    private static Consumer doNotBlankAction(String s) {
        return c -> System.out.println(s);
    }

    private static Runnable doBlankAction() {
        return () -> System.out.println("输入的参数为空");

    }
    private static Runnable falseHandle() {
        return ()-> System.out.println("false");
    }

    private static Runnable trueHandle() {
        return () -> System.out.println("true");

    }

}
