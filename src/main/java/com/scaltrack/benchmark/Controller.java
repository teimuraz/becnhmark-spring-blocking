package com.scaltrack.benchmark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@RestController
public class Controller {

    private RequestService requestService;

    @Autowired
    public Controller(RequestService requestService) {
        this.requestService = requestService;
    }

    Random rand = new Random();

    @GetMapping("/parallel-requests")
    public String parallelRequests() throws InterruptedException {
        CompletableFuture<String> res1 = requestService.makeRequest("https://emoney.ge?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res2 = requestService.makeRequest("https://github.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res3 = requestService.makeRequest("https://stackoverflow.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res4 = requestService.makeRequest("https://google.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res5 = requestService.makeRequest("https://twitter.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res6 = requestService.makeRequest("https://linkedin.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res7 = requestService.makeRequest("https://dropbox.com?p=" + rand.nextInt(99999) + 1);
//        CompletableFuture<String> res8 = requestService.makeRequest("https://amazon.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res9 = requestService.makeRequest("https://microsoft.com?p=" + rand.nextInt(99999) + 1);
        CompletableFuture<String> res10 = requestService.makeRequest("https://ebay.com?p=" + rand.nextInt(99999) + 1);

        CompletableFuture.allOf(res1, res2, res3, res4, res5, res6, res7,  res9, res10).join();
        return "Done";
    }
}
