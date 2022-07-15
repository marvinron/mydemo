package com.maviron.spring.springdemo.function.functionmode;

import java.util.Random;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Resource.java
 * @Description Resource
 * @createTime 2022年07月14日 12:32:00
 */
public class Resource {
    public Resource(){
        System.out.println("Resource created");
    }
    public void useResource(){
        riskyOperation();
        System.out.println("Resource used ");
    }
    public void employResource(){
        riskyOperation();
        System.out.println("Resource employed");
    }
    public void dispose(){
        System.out.println("Resource disposed");
    }
    private void riskyOperation(){
        if(new Random().nextInt(10) == 0){
            throw new RuntimeException();
        }
    }
}
