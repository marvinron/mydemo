package com.maviron.spring.springdemo.taskbasedmodel;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2024年03月15日 10:49:00
 */
public class Main {
    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo(2.5, 4.8);
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(priceInfo);
            threadsReader[i] = new Thread(readers[i]);
        }
        Writer writer = new Writer(priceInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++)
            threadsReader[i].start();
        threadWriter.start();
    }
}
