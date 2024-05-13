package com.maviron.spring.springdemo.responsibilitychain.example;

import com.maviron.spring.springdemo.until.Result;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName PriceCheckHandler.java
 * @Description 价格过滤
 * @createTime 2024年04月12日 10:51:00
 */
@Component
public class PriceCheckHandler extends AbstractCheckHandler {

    @Override
    public Result handle(ProductVO param) {
        System.out.println("价格校验handler开始");
        boolean illegalPrice = param.getPrice().compareTo(BigDecimal.ZERO) <= 0;
        if (illegalPrice) {
            return Result.error("非法价格进行过滤");
        }
        System.out.println("价格校验完成");

        return super.next(param);
    }
}
