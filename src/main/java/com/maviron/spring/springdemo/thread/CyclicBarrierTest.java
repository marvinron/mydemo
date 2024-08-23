package com.maviron.spring.springdemo.thread;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.util.RandomUtil;
import com.maviron.spring.springdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName CyclicBarrierTest.java
 * @Description 使用CyclicBarrier模拟同时处理并发请求
 * @createTime 2024年08月23日 11:26:00
 */
public class CyclicBarrierTest {
    Logger log = LoggerFactory.getLogger(CyclicBarrierTest.class);

    public void recordPlayAmount() throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(3000);
        log.info("开始放数据。。。。");
        StopWatch stopWatch = new StopWatch("recordCount-3000");
        stopWatch.start();
        for (int i = 0; i < 3000; i++) {
            new Thread(() -> {
                try {
                    User user = new User();
                    user.setId("21221");
                    user.setEmail("21312");
                    barrier.await();
                    //并发处理任务逻辑的方法
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }).start();
//            AdCountLogUtil.countLogInfo("1-1-1", adxLogData);
        }
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        Thread.sleep(10000L);

    }
}
