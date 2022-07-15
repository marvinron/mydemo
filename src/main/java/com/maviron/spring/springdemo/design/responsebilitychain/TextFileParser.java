package com.maviron.spring.springdemo.design.responsebilitychain;

import com.maviron.spring.springdemo.function.functionmode.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TextFileParser.java
 * @Description 文本文件解析器
 * @createTime 2022年07月14日 14:52:00
 */
public class TextFileParser extends AbstractFileParser {

    @Override
    public String parse(File file) {
        if (file.getType() == File.Type.TEXT) {
            return "Text file:" + file.getContent();
        } else if (next != null) {
            return next.parse(file);
        }else {
            throw new RuntimeException("unknown type !");
        }
    }
}
