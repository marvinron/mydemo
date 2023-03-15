package com.maviron.spring.springdemo.piplinedesign;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName StandardPipeline.java
 * @Description 创建一个pipline
 * @createTime 2023年03月03日 12:11:00
 */
public class StandardPipeline<T> implements Pipeline{

    //第一个阀门
    protected Value first;
    //基础阀门
    protected Value basic;

    @Override
    public Value getFirst() {
        return first;
    }

    @Override
    public Value getBasic() {
        return basic;
    }

    @Override
    public void setBasic(Value v) {
        basic = v;
    }

    @Override
    public void addValve(Value v) {
        if (first == null) {
            first = v;
            v.setNext(basic);
        } else {
            Value current = first;
            while (current != null) {
                if (current.getNext() == basic) {
                    current.setNext(v);
                    v.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }

    }
}
