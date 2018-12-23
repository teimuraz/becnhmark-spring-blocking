package com.scaltrack.benchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableAsync
public class BenchmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchmarkApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		return Executors.newFixedThreadPool(400);
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		executor.setCorePoolSize(20);
//		executor.setMaxPoolSize(25);
//		executor.setQueueCapacity(500);
//		executor.setThreadNamePrefix("ParallelRequests-");
//		executor.initialize();
//		return executor;
	}

}

