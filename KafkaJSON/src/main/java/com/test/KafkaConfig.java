package com.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.core.*;

/*
https://www.onlinetutorialspoint.com/spring-boot/spring-boot-kafka-consume-json-messages-example.html
https://stackoverflow.com/questions/43007650/error-handling-with-kafkalistener
https://medium.com/@anushan.15/deserialization-error-handling-in-kafka-with-spring-boot-1701495bfded
*/

@EnableKafka
@Configuration
public class KafkaConfig {

	@Bean
	public ConsumerFactory<String,Item> consumerFactory() {
		Map<String,Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "sample-group");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(Item.class));
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
    public ConcurrentKafkaListenerContainerFactory<String, Item> kafkaListener(){
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        
        factory.setConsumerFactory(consumerFactory());
        factory.setErrorHandler(new ErrorHandlerJSON());

        
        return factory;
    }
	
	
}	

