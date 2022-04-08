package com.iplacex.microservices.camelconsumera.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiverRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception{
		//lectura de cola
		from("activemq:activemq-empresa-adidas")
		.to("log:activemq-empresa-adidas")
		.log("${body}")
		.end();
		
		//lectura de cola
		from("activemq:activemq-empresa-fila")
		.to("log:activemq-empresa-fila")
		.log("${body}")
		.end();
		
		//lectura de cola
		from("activemq:activemq-empresa-puma")
		.to("log:activemq-empresa-puma")
		.log("${body}")
		.end();
	}
}
