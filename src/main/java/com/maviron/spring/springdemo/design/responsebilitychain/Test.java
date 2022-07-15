package com.maviron.spring.springdemo.design.responsebilitychain;

import com.maviron.spring.springdemo.function.functionmode.File;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 责任链测试类
 * @createTime 2022年07月14日 15:18:00
 */
public class Test {
    public static void main(String[] args) {
        TextFileParser textFileParser = new TextFileParser();
        AudioFileParser audioFileParser = new AudioFileParser();
        VideoFileParser videoFileParser = new VideoFileParser();
        textFileParser.setNextParser(audioFileParser);
        audioFileParser.setNextParser(videoFileParser);

        File file = new File(File.Type.AUDIO, "audio audio is audio");
        textFileParser.parse(file);

    }
}
