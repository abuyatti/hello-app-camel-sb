package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// @formatter:off

		rest().path("/api")

		.get("/hello")
			.outType(ResponseType.class)
			.to("bean:helloBean")

		.get("/hello/{name}")
			.outType(ResponseType.class)
			.to("direct:sayHello");

		from("direct:sayHello")
			.setBody(e -> new ResponseType("Hello " + e.getIn().getHeader("name")));

		// @formatter:on
	}

}
