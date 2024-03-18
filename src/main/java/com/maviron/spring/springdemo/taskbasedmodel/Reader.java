package com.maviron.spring.springdemo.taskbasedmodel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Reader.java
 * @Description TODO
 * @createTime 2024年03月15日 10:41:00
 */
public class Reader implements Runnable {
    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: price 1:%f\n", Thread.currentThread().getName(), priceInfo.getPrice1());
            System.out.printf("%s: price 2:%f\n", Thread.currentThread().getName(), priceInfo.getPrice2());
        }
    }
}
