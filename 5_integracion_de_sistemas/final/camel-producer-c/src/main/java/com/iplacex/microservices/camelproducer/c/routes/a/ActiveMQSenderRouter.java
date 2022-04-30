package com.iplacex.microservices.camelproducer.c.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducer.c.model.DatosFinancieros;
import com.iplacex.microservices.camelproducer.c.repository.ParametroRepo;


@Component
public class ActiveMQSenderRouter extends RouteBuilder{
	@Autowired
	ParametroRepo parametroRepo;
	
	@Override
	public void configure() throws Exception {
		
		errorHandler(deadLetterChannel("log:dead?level=ERROR"));
		
		//Proceso que actualiza el registro en Cola MQ
		from("direct:dejarMsgQueue")
		.log("${body.empresaVigente}")
		.choice()
			.when().simple("${body.empresaVigente} == true")
				.log("empresa vigente")
				.marshal(new JacksonDataFormat(DatosFinancieros.class))
				.to("activemq:activemq-datos-financieros")
			.otherwise()
				.log("DeadLetterQueue")
				.marshal(new JacksonDataFormat(DatosFinancieros.class))
				.to("activemq:DeadLetterQueue")
				
		.endChoice();		 
	 }
}
