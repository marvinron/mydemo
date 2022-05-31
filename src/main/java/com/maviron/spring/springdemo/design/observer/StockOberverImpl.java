package com.maviron.spring.springdemo.design.observer;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName StockOberverImpl.java
 * @Description TODO
 * @createTime 2022年04月25日 11:01:00
 */
public class StockOberverImpl implements Observer {
    @Override
    public void notify(String orderNo) {
        System.out.printf("订单[%s]库存服务已更新\n",orderNo);
    }
}
