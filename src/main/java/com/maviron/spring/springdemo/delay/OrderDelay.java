package com.maviron.spring.springdemo.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderDelay.java
 * @Description 延迟订单
 * @createTime 2023年03月06日 10:52:00
 */
public class OrderDelay implements Delayed {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 超时时间
     */
    private long timeout;

    public OrderDelay(String orderId, long timeout) {
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this == o) {
            return 0;
        }
        OrderDelay t = (OrderDelay) o;
        long d = (getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }
    void print() {
        System.out.println(orderId + "编号的订单要删除啦。。。。");
    }
}
