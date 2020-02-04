package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
public class ItemController {

	@Autowired
	KafkaTemplate<String,String> template;
	String TOPIC_NAME="items-topic";
	
	@GetMapping("/say/{msg}")
	public String postMessage(@PathVariable("msg") String msg) {
		template.send(TOPIC_NAME, msg);
		return "Message published successfully.";
	}
}
