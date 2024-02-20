package com.maviron.spring.springdemo.springstatemachine.controller;

import com.maviron.spring.springdemo.springstatemachine.entity.AdsOrderBak;
import com.maviron.spring.springdemo.springstatemachine.service.OrderServiceImpl;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URL;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName OrderController.java
 * @Description 订单controller
 * @createTime 2024年02月19日 15:14:00
 */
@RestController
@RequestMapping("/order")
public class AdsOrderController {
    @Resource
    private OrderServiceImpl orderService;

    @RequestMapping("getById")
    public AdsOrderBak getById(Integer id) {
        //根据id查询订单
        AdsOrderBak orderById = orderService.getOrderById(id);
        return orderById;
    }

    @RequestMapping("/create")
    public AdsOrderBak create(@RequestBody AdsOrderBak orderBak) {
        orderService.createOrder(orderBak);
        return orderBak;
    }

    @SneakyThrows
    public static void main(String[] args) {
        String deeplink = "tbopen://m.taobao.com/tbopen/index.html?source=auto&action=ali.open.nav&module=h5&bootImage=0&spm=2014.ugdhh.2200803434969.227889-1783920-32768&activity_id=520093001&bc_fl_src=growth_dhh_2200803434969_227889-1783920-32768&materialid=227889&afc_route=1&h5Url=https%3A%2F%2Fpages.tmall.com%2Fwow%2Fbz%2Fjingmi%2F676%3Fwh_biz%3Dtm%26disableNav%3DYES%26moduleChannel%3Djulang%26spmb%3D27774788%26spm%3D2014.ugdhh.2200803434969.227889-1783920-32768%26activity_id%3D520093001%26bc_fl_src%3Dgrowth_dhh_2200803434969_227889-1783920-32768";
        URI url = new URI(deeplink);
        String scheme = url.getScheme();
        System.out.println(scheme);
    }
}
