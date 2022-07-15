package com.maviron.spring.springdemo.design.responsebilitychain;

import com.maviron.spring.springdemo.function.functionmode.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstractFileParser.java
 * @Description 抽象的解析类处理器
 * @createTime 2022年07月14日 14:42:00
 */
public abstract class AbstractFileParser implements FileParser {

    protected FileParser next;
    @Override
    public abstract String parse(File file);

    @Override
    public void setNextParser(FileParser next){
        this.next = next;
    }
}
