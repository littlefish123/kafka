package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude=KafkaAutoConfiguration.class)
public class KafkaJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaJsonApplication.class, args);
	}

}
