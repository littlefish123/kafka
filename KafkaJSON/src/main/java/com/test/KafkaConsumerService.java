package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@Bean
	public RecordMessageConverter converter() {
		return new StringJsonMessageConverter();
	}

	@KafkaListener(topics="items-topic",groupId="sample-group",containerFactory = "kafkaListener")
	public void consume(Item item) {
		System.out.println("Consumed Item"  + item);
	}
	
	@KafkaListener(topics="items-topic",groupId="sample-group",containerFactory = "kafkaListener")
	public void listen(Item item) {
		System.out.println("Consumed Item"  + item);
		if (item.getName().startsWith("fail")) {
			throw new RuntimeException("failed");
		}

	}
	
	
}
