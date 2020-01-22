package com.test;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runProducer();
	}
	
	static void runProducer() {
		Producer<Long,String> producer = ProducerCreator.createProducer();
		
		for (int index=0; index < IkafkaConstants.MESSAGE_COUNT; index++) {
			ProducerRecord<Long,String> record = new ProducerRecord<Long,String>(IkafkaConstants.TOPIC_NAME,
					"this is record " + index);			
		
		
			try {
				RecordMetadata metaData = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition" + metaData.partition()
				+ " with offset" + metaData.offset());			
			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}

}
