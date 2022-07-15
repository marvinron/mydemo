package com.maviron.spring.springdemo.function.functionmode;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FileParser.java
 * @Description 文件解析接口
 * @createTime 2022年07月14日 15:26:00
 */
public interface FileParser {
    String parse(File file);
    void setNextParser(FileParser next);
}
