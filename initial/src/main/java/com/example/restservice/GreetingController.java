package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {
	
	private static AtomicLong id_counter = new AtomicLong();
	private static final String template = "Hello, %s!";

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue="World") String name) {
		
		return new Greeting(id_counter.incrementAndGet(), String.format(template, name));
	}
	
	
}
