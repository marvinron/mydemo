package com.maviron.spring.springdemo.demo;

import java.util.function.Function;

// 请求对象
class Request {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

// 响应对象
class Response {
    private String data;

    public Response(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

// 请求处理器接口
interface RequestHandler extends Function<Request, Response> {
    default RequestHandler andThen(RequestHandler next) {
        return request -> next.apply(request);
    }
}

// 第一个处理器：处理大写转换
class UpperCaseHandler implements RequestHandler {
    @Override
    public Response apply(Request request) {
        String processedData = request.getData().toUpperCase();
        return new Response(processedData);
    }
}

// 第二个处理器：处理添加后缀
class AddSuffixHandler implements RequestHandler {
    @Override
    public Response apply(Request request) {
        String processedData = request.getData() + "_processed";
        return new Response(processedData);
    }
}

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // 构建请求处理器链
        RequestHandler handlerChain = new UpperCaseHandler().andThen(new AddSuffixHandler());

        // 创建请求对象
        Request request = new Request("hello");

        // 执行请求处理器链
        Response response = handlerChain.apply(request);

        // 输出处理结果
        System.out.println("Processed data: " + response.getData()); // 输出: Processed data: HELLO_processed
    }
}
