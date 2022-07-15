package com.maviron.spring.springdemo.design.responsebilitychain;

import com.maviron.spring.springdemo.function.functionmode.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName AudioFileParser.java
 * @Description 音频解析器
 * @createTime 2022年07月14日 15:07:00
 */
public class AudioFileParser extends AbstractFileParser {
    @Override
    public String parse(File file) {
        if (file.getType() == File.Type.AUDIO) {
            return "Audio file:" + file.getContent();
        }else if (next != null) {
            return next.parse(file);
        }else {
            throw new RuntimeException("unknown type !");
        }
    }
}
