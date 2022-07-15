package com.maviron.spring.springdemo.component;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.maviron.spring.springdemo.disrupter.consumer.HelloEventHandler;
import com.maviron.spring.springdemo.disrupter.factory.HelloEventFactory;
import com.maviron.spring.springdemo.disrupter.model.MessageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MQManager.java
 * @Description 构造MQManager
 * @createTime 2022年06月27日 18:04:00
 */
@Configuration
public class MQManager {
    @Bean("messageModel")
    public RingBuffer<MessageModel> messageModelRingBuffer() {
        //获取处理事件的线程池
        ExecutorService executorService =
                Executors.newFixedThreadPool(4);
        //指定事件工厂
        HelloEventFactory factory = new HelloEventFactory();
        //指定ringbuffer的字节的大小
        int bufferSize = 1024 * 256;
        //单线程模式 获取额外的性能
        Disruptor<MessageModel> disruptor = new Disruptor<MessageModel>(factory, bufferSize, executorService, ProducerType.SINGLE, new BlockingWaitStrategy());
        //设置事件的消费者
        disruptor.handleEventsWith(new HelloEventHandler());
        //启动disruptor
        disruptor.start();
        RingBuffer<MessageModel> ringBuffer = disruptor.getRingBuffer();
        return ringBuffer;

    }

    public static void main(String[] args) {
        System.out.println("请输入一个数:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("输入的数是 " + i);
    }
}
