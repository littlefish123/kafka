package com.test;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomSerializer implements Serializer<CustomObject> {
	
	public void configure(Map<String,?> configs, boolean isKey) {
		
	}
	
	public byte[] serialize(String topic, CustomObject data) {
		byte[] retVal = null;
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			retVal = objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception exception) {
			System.out.println("Error in serializer object" + data);
		}
		
		return retVal;
	}
	
	public void close() {
		
	}

}
