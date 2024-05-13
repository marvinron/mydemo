package com.maviron.spring.springdemo.responsibilitychain.example;

import com.maviron.spring.springdemo.until.Result;
import org.springframework.stereotype.Component;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName StockCheckHandler.java
 * @Description 库存校验
 * @createTime 2024年04月12日 10:51:00
 */
@Component
public class StockCheckHandler extends AbstractCheckHandler {
    @Override
    public Result handle(ProductVO param) {
        System.out.println("库存校验handler开始");
        boolean illeagalStock = param.getStock() <= 0;
        if (illeagalStock) {
            return Result.error("非法库存校验过滤");
        }
        System.out.println("库存校验handler结束");
        return super.next(param);
    }
}
