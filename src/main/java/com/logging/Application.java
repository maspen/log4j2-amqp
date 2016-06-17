package com.logging;

import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application {

	private static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Hit 'Enter' to terminate");
		System.in.read();
		ctx.close();
	}
	
	@Scheduled(fixedDelay = 1000, initialDelay=2000)
	public void sendLog() {
		logger.info("Log via AmqpAppender: " + new Date());
	}
}
