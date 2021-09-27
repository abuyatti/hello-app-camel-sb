package com.example;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

	public ResponseType greeting() {
		return new ResponseType("Greetings from Apache Camel and Spring Boot!");
	}

}
