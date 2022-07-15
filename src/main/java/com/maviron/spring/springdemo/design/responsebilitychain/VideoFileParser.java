package com.maviron.spring.springdemo.design.responsebilitychain;

import com.maviron.spring.springdemo.function.functionmode.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName VideoFileParser.java
 * @Description 视频解析器
 * @createTime 2022年07月14日 15:11:00
 */
public class VideoFileParser extends AbstractFileParser {
    @Override
    public String parse(File file) {
        if (file.getType() == File.Type.VIDEO) {
            return "video file " + file.getContent();
        }else if (next != null) {
            return next.parse(file);
        }else {
            throw new RuntimeException("unknown video file !");
        }
    }
}
