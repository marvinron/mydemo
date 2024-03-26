package com.maviron.spring.springdemo.cache;

import cn.hutool.core.date.StopWatch;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName LRUCachecaffeine.java
 * @Description 基于caffeine的实现
 * @createTime 2024年03月11日 11:53:00
 *
 * <dependency>
 * <groupId>com.github.ben-manes.caffeine</groupId>
 * <artifactId>caffeine</artifactId>
 * <version>2.9.3</version>
 * </dependency>
 * <p>
 * https://zhuanlan.zhihu.com/p/345175951
 * https://juejin.cn/post/7091965051380170788
 * SpringBoot整合Caffeine  https://developer.aliyun.com/article/1238521
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-cache</artifactId>
 * </dependency>
 *
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-cache</artifactId>
 * </dependency>
 * <dependency>
 * <groupId>com.github.ben-manes.caffeine</groupId>
 * <artifactId>caffeine</artifactId>
 * </dependency>
 *
 * https://github.com/ben-manes/caffeine/wiki/Eviction-zh-CN
 */
@Slf4j
public class LRUCachecaffeine {

    public static void main(String[] args) throws Exception{
        /*AsyncLoadingCache<String, String> loadingCache = Caffeine.newBuilder()
                .maximumSize(2)
                // .weigher()
                .expireAfterWrite(1, TimeUnit.DAYS)
                // .scheduler()
                .refreshAfterWrite(1L, TimeUnit.SECONDS)
                .buildAsync((key) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("adssada========");
                    return key + " build";
                });
        // loadingCache.put("nem", "1");
        // loadingCache.put("nam", "1");
        // loadingCache.put("ntm", "1");
        // loadingCache.put("12321",CompletableFuture.supplyAsync(()->"12321"));
        // loadingCache.put("12322",CompletableFuture.supplyAsync(()->"12321"));
        // loadingCache.put("12323",CompletableFuture.supplyAsync(()->"12321"));
        // loadingCache.put("12324",CompletableFuture.supplyAsync(()->"12321"));
        // loadingCache.put("12325",CompletableFuture.supplyAsync(()->"12321"));
        // Thread.sleep(1000);
        // String name = Thread.currentThread().getName();
        // System.out.println(name);
        // CompletableFuture<String> nem = loadingCache.get("nem");
        // System.out.println(nem.get(1,TimeUnit.MILLISECONDS));
        // Thread.sleep(1000000);
        for (int i = 0; i < 10; i++) {
            String nem1 = loadingCache.get("nem_"+i).get();
            System.out.println(nem1);
        }
        loadingCache.get("nem_2");
        System.out.println(loadingCache.asMap());*/
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        com.github.benmanes.caffeine.cache.LoadingCache<String, String> caffeineCache = Caffeine.newBuilder()
                .maximumSize(2)
                // .expireAfterWrite(20, TimeUnit.SECONDS)
                // .refreshAfterWrite(1, TimeUnit.SECONDS)
                .build(key -> {
                    log.info("加载数据");
                    // 加载时,睡眠一秒
                    // Thread.sleep(5000);
                    return key + System.currentTimeMillis();
                });

       /*AsyncLoadingCache<Object, String> caffeineCache = Caffeine.newBuilder()
                .maximumSize(2)
                .buildAsync((key) -> {
                    log.info("加载数据");
                    return String.valueOf(key + " build");
                });
        caffeineCache.put("dabai",CompletableFuture.supplyAsync(()->"12321"));
        caffeineCache.put("xiaobai",CompletableFuture.supplyAsync(()->"12321"));
        caffeineCache.put("xiaobai1",CompletableFuture.supplyAsync(()->"12321"));*/
        caffeineCache.put("dabai","12312");
        caffeineCache.put("dabai1","12312");
        caffeineCache.put("dabai2","12312");
        caffeineCache.get("nem_2");
        caffeineCache.get("nem_2");
        caffeineCache.get("nem_21");
        caffeineCache.get("nem_21");
        caffeineCache.get("nem_21");
        System.out.println(caffeineCache.asMap());
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

    }
}
