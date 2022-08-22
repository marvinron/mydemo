package com.maviron.spring.springdemo.SplitListUtils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AsyncSplitList.java
 * @Description 异步线程池对拆分后的集合进行处理
 * @createTime 2022年08月22日 10:25:00
 */
public class  AsyncSplitList<T> {
    public void threadMethod(List<T> totalList) {
        List<T> updateList = new ArrayList();
        // 初始化线程池, 参数一定要一定要一定要调好！！！！
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(20, 50,
                4, TimeUnit.SECONDS, new ArrayBlockingQueue(10), new ThreadPoolExecutor.AbortPolicy());
        // 大集合拆分成N个小集合, 这里集合的size可以稍微小一些（这里我用100刚刚好）, 以保证多线程异步执行, 过大容易回到单线程
        List<List<T>> splitNList = SplitListUtils.split(totalList, 100);
        // 记录单个任务的执行次数
        CountDownLatch countDownLatch = new CountDownLatch(splitNList.size());
        // 对拆分的集合进行批量处理, 先拆分的集合, 再多线程执行
        for (List<T> singleList : splitNList) {
            // 线程池执行
            threadPool.execute(new Thread(new Runnable(){
                @Override
                public void run() {
                    //for (Entity yangshiwen : singleList) {
                    //    // 将每一个对象进行数据封装, 并添加到一个用于存储更新数据的list
                    //    // ......
                    //
                    //}
                }
            }));
            // 任务个数 - 1, 直至为0时唤醒await()
            countDownLatch.countDown();
        }
        try {
            // 让当前线程处于阻塞状态，直到锁存器计数为零
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        // 通过mybatis的批量插入的方式来进行数据的插入, 这一步还是要做判空
        if (CollectionUtils.isNotEmpty(updateList)) {
            //batchUpdateEntity(updateList);
            //LogUtil.info("xxxxxxxxxxxxxxx");
        }
    }
}
