package com.maviron.spring.springdemo.piplinedesign;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 测试pipLine
 * @createTime 2023年03月03日 12:19:00
 */
public class Test {
    public static void main(String[] args) {
        String s = "test";
        StandardPipeline pipeline = new StandardPipeline();
        BasicValve<String> basic = new BasicValve<>();
        SecondValue<String> secondValue = new SecondValue<>();
        ThirdValve<String> thirdValue = new ThirdValve<>();

        pipeline.setBasic(basic);
        pipeline.addValve(secondValue);
        pipeline.addValve(thirdValue);
        pipeline.getFirst().invoke(s);
    }
}
