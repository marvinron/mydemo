package com.maviron.spring.springdemo.function.templatemethod8;

import java.util.function.Consumer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PushTemplateLambda.java
 * @Description TODO
 * @createTime 2022年04月25日 09:47:00
 */
public class PushTemplateLambda {

    public void push(int customerId, String shopName, Consumer<Object[]> excute){
        System.out.println("准备配送。。。。。\n");
        Object[] param = new Object[]{customerId, shopName};
        excute.accept(param);
        System.out.println("配送完成。。。。。\n");
    }
    private static Consumer<Object[]> doHandle(int customerId, String shopName){
        return objects -> System.out.println(customerId + "========" + shopName);
    }

    public static void main(String[] args) {
        new PushTemplateLambda().push(1,"糖果店",(Object[] obj)->{
            System.out.println(obj[0]+"===="+obj[1]);
        });
        new PushTemplateLambda().push(2,"糖果店",doHandle(2,"糖果店"));
    }
}
