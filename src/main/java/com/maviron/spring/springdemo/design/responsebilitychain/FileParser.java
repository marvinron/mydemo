package com.maviron.spring.springdemo.design.responsebilitychain;

import com.maviron.spring.springdemo.function.functionmode.File;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FileParser.java
 * @Description 解析文件并设置下一个解析文件
 * @createTime 2022年07月14日 14:40:00
 */
public interface FileParser {
    String parse(File file);
    void setNextParser(FileParser next);
}
