package com.maviron.spring.springdemo.transfer;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class HttpAdServer {

    private TransferQueue<HttpAdRequest> requestQueue = new LinkedTransferQueue<>();
    private TransferQueue<HttpAdResponse> responseQueue = new LinkedTransferQueue<>();

    public void handleHttpRequest(HttpAdRequest request) {
        try {
            requestQueue.transfer(request); // 将HTTP广告请求放入请求队列
            HttpAdResponse response = responseQueue.take(); // 从响应队列获取HTTP广告响应
            sendHttpResponse(response); // 发送HTTP响应
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Failed to handle HTTP request: " + e.getMessage());
        }
    }

    public void processAdRequests() {
        new Thread(() -> {
            while (true) {
                try {
                    HttpAdRequest request = requestQueue.take(); // 从请求队列获取HTTP广告请求
                    HttpAdResponse response = generateAdResponse(request); // 生成HTTP广告响应
                    Thread.sleep(10000);
                    responseQueue.transfer(response); // 将HTTP广告响应放入响应队列
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Failed to process ad request: " + e.getMessage());
                }
            }
        }).start();
    }

    private HttpAdResponse generateAdResponse(HttpAdRequest request) {
        // 根据HTTP广告请求生成对应的HTTP广告响应
        // 这里只是简单返回一个示例响应
        return new HttpAdResponse("200 OK", "Ad content goes here");
    }

    private void sendHttpResponse(HttpAdResponse response) {
        System.out.println("Sending HTTP response: " + response.getStatus() + " - " + response.getContent());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            HttpAdServer adServer = new HttpAdServer();
            adServer.processAdRequests();

            // 模拟接收HTTP广告请求并处理
            HttpAdRequest request = new HttpAdRequest("http://example.com/ad-request");
            adServer.handleHttpRequest(request);
        }
    }
}

class HttpAdRequest {
    private String url;

    public HttpAdRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

class HttpAdResponse {
    private String status;
    private String content;

    public HttpAdResponse(String status, String content) {
        this.status = status;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
