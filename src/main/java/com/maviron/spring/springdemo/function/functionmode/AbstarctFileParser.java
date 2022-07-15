package com.maviron.spring.springdemo.function.functionmode;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AbstarctFileParser.java
 * @Description 文件解析抽象类
 * @createTime 2022年07月14日 15:25:00
 */
public abstract class AbstarctFileParser implements FileParser {

    protected FileParser next;
    @Override
    public abstract String parse(File file);

    @Override
    public void setNextParser(FileParser next){
        this.next = next;
    }
}
