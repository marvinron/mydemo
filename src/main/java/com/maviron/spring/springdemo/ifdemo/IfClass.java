package com.maviron.spring.springdemo.ifdemo;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName IfClass.java
 * @Description TODO
 * @createTime 2024年03月29日 18:02:00
 */
public class IfClass {
    public static void main(String[] args) {
        String orderStatusDes;
        String orderStatus = "1";
        if ("1".equals(orderStatus)) {
            orderStatusDes = "订单未支付";
        } else if ("2".equals(orderStatus)) {
            orderStatusDes = "订单已支付";
        } else if ("3".equals(orderStatus)) {
            orderStatusDes = "订单已发货";
        } else if ("4".equals(orderStatus)) {
            orderStatusDes = "订单已签收";
        } else if ("5".equals(orderStatus)) {
            orderStatusDes = "订单已评价";
        }
        //上述if可以使用枚举进行优化 如果使用枚举 可以只有一行代码
        String orderStatusOptimizeDes = OrderStatusEnum.of(orderStatus).getStatusDes();

    }
}
