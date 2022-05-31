package com.maviron.spring.springdemo.async;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ThreadDecorator.java
 * @Description ThreadDecorator
 * @createTime 2022年05月11日 16:19:00
 */
@FunctionalInterface
public interface ThreadDecorator {

    Runnable decorate(Runnable r);
}
