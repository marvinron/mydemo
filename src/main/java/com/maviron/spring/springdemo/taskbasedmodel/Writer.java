package com.maviron.spring.springdemo.taskbasedmodel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Writer.java
 * @Description TODO
 * @createTime 2024年03月15日 10:47:00
 */
public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        System.out.printf("Writer: Attempt to modify the prices.\n");
        priceInfo.setPrice(Math.random() * 10, Math.random() * 8);
        System.out.printf("Writer: Prices has been modified.\n");
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
