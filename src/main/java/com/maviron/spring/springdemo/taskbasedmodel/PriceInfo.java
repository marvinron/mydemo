package com.maviron.spring.springdemo.taskbasedmodel;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PriceInfo.java
 * @Description Task-based模式的实现
 * @createTime 2024年03月15日 09:59:00
 */
public class PriceInfo {
    private double price1;
    private double price2;

    private ReadWriteLock lock;

    public PriceInfo(double price1, double price2) {
        this.price1 = price1;
        this.price2 = price2;
        this.lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

    public void setPrice(double price1, double price2) {
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }
}
