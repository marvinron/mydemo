package com.maviron.spring.springdemo.responsibilitychain.example;

import com.maviron.spring.springdemo.until.Result;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName NullValueCheckHandler.java
 * @Description 空值校验处理器
 * @createTime 2024年04月12日 10:50:00
 */
@Component
public class NullValueCheckHandler extends AbstractCheckHandler {

    @Override
    public Result handle(ProductVO param) {

        System.out.println("空值校验 Handler 开始...");
        //如果配置了降级 则跳过处理器 执行下一个处理器
        if (super.getConfig().getDown()) {
            System.out.println("空值校验已降级，跳过空值校验");
            return super.next(param);
        }
        //参数必填校验
        if (Objects.isNull(param)) {
            return Result.error("参数是空");
        }
        //校验参数skuId是否是空
        if (Objects.isNull(param.getSkuId())) {
            return Result.error("Sku Id 是空");
        }
        //校验参数是否必填
        if (Objects.isNull(param.getPrice())) {
            return Result.error("price 价格是空");
        }
        //库存参数必填
        if (Objects.isNull(param.getStock())) {
            return Result.error("库存参数必填");
        }
        System.out.println("所有校验参数通过");

        return super.next(param);
    }
}
