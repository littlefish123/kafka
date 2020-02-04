package com.test;

/*
https://www.confluent.io/blog/spring-for-apache-kafka-deep-dive-part-1-error-handling-message-conversion-transaction-support/
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude=KafkaAutoConfiguration.class)
public class KafkaJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaJsonApplication.class, args);
	}

}
