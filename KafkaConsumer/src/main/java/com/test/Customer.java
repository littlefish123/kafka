package com.test;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runCustomer();
	}

	static void runCustomer() {
		Consumer<Long,String> consumer = ConsumerCreator.createConsumer();
		
		int noMessageFound = 0;
		
		while (true) {
			@SuppressWarnings("deprecation")
			ConsumerRecords<Long,String> consumerRecords = consumer.poll(1000);
			
			if (consumerRecords.count() == 0) {
				noMessageFound++;
				if (noMessageFound > IkafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT) 
					break;
				else
					continue;
			}
	
	
	consumerRecords.forEach(record -> {
		System.out.println("Record key " + record.key());
		System.out.println("Record value " + record.value());
		System.out.println("Record partition " + record.partition());
		System.out.println("Record offset " + record.offset());
	    });
	
	    consumer.commitAsync();
	}
	
	consumer.close();
	}
}
