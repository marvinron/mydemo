package com.maviron.spring.springdemo.function.functionmode;

import com.maviron.spring.springdemo.design.decorate.Taxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName FunctionModeTest.java
 * @Description 使用函数实现模式
 * @createTime 2022年07月14日 12:23:00
 */
public class FunctionModeTest {
    public static void main(String[] args) {
        //命令模式
        //List<Runnable> tasks = new ArrayList<Runnable>();
        //tasks.add(() -> log("log hi"));
        //tasks.add(() -> save("save haha"));
        //tasks.add(() -> send("send wwww"));
        //execute(tasks);
        //
        ////模板模式
        //withResource(Resource::employResource);
        //withResource(Resource::useResource);
        ////职责链模式
        //File file = new File(File.Type.VIDEO, "video video i am video");
        //String s = Stream.<Function<File, Optional<String>>>of(FunctionModeTest::parseText, FunctionModeTest::parseAudio, FunctionModeTest::parseVideo).map(f -> f.apply(file))
        //        .filter(Optional::isPresent)
        //        .findFirst()
        //        .flatMap(Function.identity())
        //        .orElseThrow(() -> new RuntimeException("unknown type !"));
        //函数的装饰模式
        double v = new DefaultFunctionSalaryCalculator()
                .andThen(Taxes::generalTax)
                .andThen(Taxes::regionalTax)
                .andThen(Taxes::healthInsurance)
                .applyAsDouble(30000);
        System.out.println(v);



    }

    //命令模式 start
    public static void execute(List<Runnable> tasks) {
        tasks.forEach(Runnable::run);
    }

    public static void log(String message) {
        System.out.println("Logging: " + message);
    }

    public static void save(String message) {
        System.out.println("Saving: " + message);
    }

    public static void send(String message) {
        System.out.println("Sending: " + message);
    }
    //命令模式 end

    //模板模式的方法 start
    public static void withResource(Consumer<Resource> consumer) {
        Resource resource = new Resource();
        try {
            consumer.accept(resource);
        } finally {
            resource.dispose();
        }
    }
    //模板模式的方法 end

    //职责连模式 start
    public static Optional<String> parseText(File file) {
        return file.getType() == File.Type.TEXT ?
                Optional.of("Text file: " + file.getContent()) :
                Optional.empty();
    }

    public static Optional<String> parseAudio(File file) {
        return file.getType() == File.Type.AUDIO ?
                Optional.of("Audio file: " + file.getContent()) :
                Optional.empty();
    }

    public static Optional<String> parseVideo(File file) {
        return file.getType() == File.Type.VIDEO ?
                Optional.of("Video file: " + file.getContent()) :
                Optional.empty();
    }
    //职责链模式 end

    //访问者模式的方法 start

    //访问者模式的方法 end


}
