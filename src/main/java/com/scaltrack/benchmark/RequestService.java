package com.scaltrack.benchmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class RequestService {

    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public RequestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<String> makeRequest(String url) throws InterruptedException {
//        logger.info("Making request to url " + url);
        String result = "";
        result = restTemplate.getForObject(url, String.class);
        return CompletableFuture.completedFuture(result);
    }
}
