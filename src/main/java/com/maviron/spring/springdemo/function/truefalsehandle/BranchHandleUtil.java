package com.maviron.spring.springdemo.function.truefalsehandle;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BranchHandleUtil.java
 * @Description TODO
 * @createTime 2022年04月15日 11:14:00
 */
public class BranchHandleUtil {

    public static BranchHandle doHandle(boolean result) {
        return (trueHnadle, falseHandle) -> {
            if (result) {
                trueHnadle.run();
            } else {
                falseHandle.run();
            }
        };
    }

    public static void main(String[] args) {
        BranchHandleUtil.doHandle(true).trueOrFalseHandle(trueHandle(),falseHandle());
    }

    private static Runnable falseHandle() {
        return ()-> System.out.println("false");
    }

    private static Runnable trueHandle() {
        return () -> System.out.println("true");

    }
}
