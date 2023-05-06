package com.maviron.spring.springdemo.piplinedesign.piplinecontext;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 测试
 * @createTime 2023年05月06日 11:40:00
 */
public class Test {
    public static void main(String[] args) {
        MyPipeline pipeline = new MyPipeline();
        pipeline.addFirst(new TestHandler2());//添加handler2
        pipeline.addFirst(new TestHandler1());//添加handler1
        for (int i = 0; i < 10; i++) {//提交多个任务
            pipeline.Request("hello" + i);
        }
    }
}
