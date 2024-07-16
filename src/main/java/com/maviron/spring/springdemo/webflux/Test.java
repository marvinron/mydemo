package com.maviron.spring.springdemo.webflux;

import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
        WebClient webClient = WebClient.builder()
                .clientConnector(createClientConnector())
                .filter(logRequestTime())
                .build();

        CompletableFuture<ClientResponse> responseFuture = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .exchange()
                .toFuture();

        try {
            ClientResponse response = responseFuture.get();
            System.out.println(response.bodyToMono(String.class).block());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static ClientHttpConnector createClientConnector() {
        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(5));
        return new ReactorClientHttpConnector(httpClient);
    }

    private static ExchangeFilterFunction logRequestTime() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            long startTime = System.currentTimeMillis();
            return Mono.just(clientRequest)
                    .doOnSuccess(clientRequest1 -> {
                        long endTime = System.currentTimeMillis();
                        long requestTime = endTime - startTime;
                        System.out.println("Request to " + clientRequest1.url() + " took " + requestTime + " ms");
                    });
        });
    }
}