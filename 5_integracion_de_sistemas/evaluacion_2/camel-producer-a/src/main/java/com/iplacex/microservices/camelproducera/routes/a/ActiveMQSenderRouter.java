package com.iplacex.microservices.camelproducera.routes.a;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducera.model.Parametro;
import com.iplacex.microservices.camelproducera.model.Pedido;
import com.iplacex.microservices.camelproducera.repository.ParametroRepo;


@Component
public class ActiveMQSenderRouter extends RouteBuilder{
	@Autowired
	ParametroRepo parametroRepo;
	
	@Override
	public void configure() throws Exception {
		
		//Se genera un timer para consultar end-point
		//que devuelve los pedidos pendiente de realizar
		from("timer:simple?period=1000")
		.log("--- iniciar proceso ---")
		.to("direct:consumirWSRestGET")
		.end();
		
		//Consulta end-point de pedidos existentes
		from("direct:consumirWSRestGET")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.GET))
		.to("http://127.0.0.1:3000/ordenes?realizado=false")
		.log("Recuperar via get los pedidos no realizados")
		.unmarshal(new ListJacksonDataFormat(Pedido.class))
		.setBody(simple("${body}"))
		.choice()
			.when(body().isNotNull())
				.split(body())
					.log("Procesar contenido")
					.process(exchange->{
						//Se rescata de base de datos los parametros adicionales
						Pedido pedido = exchange.getIn().getBody(Pedido.class);
						if(pedido != null) {
							System.out.println("... procesando Pedido ID "+ pedido.getId());
							List<Parametro> parametros = parametroRepo.findAllByEmpresa(pedido.getEmpresa());							
							if(parametroRepo != null) {			
								for (Parametro parametro : parametros) {
									pedido.setDataAdicional(parametro.getInfoAdicional());	
								}
							}
							pedido.setRealizado(true);
							exchange.getOut().setBody(pedido);
						}
					})
					.to("direct:consumirWSRestPUT")
		.endChoice()
		.end();
		
		//Proceso que actualiza el registro
		from("direct:consumirWSRestPUT")
		.log("actualizar estatus via Rest PUT")
		.to("direct:dejarMsgQueue")
		.unmarshal(new JacksonDataFormat(Pedido.class))
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.PATCH))
		.setHeader(Exchange.HTTP_PATH, simple("/${body.id}"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.marshal(new JacksonDataFormat(Pedido.class))
		.to("http://127.0.0.1:3000/ordenes")		
		.end();
		
		//Proceso que actualiza el registro en Cola MQ
		from("direct:dejarMsgQueue")
		.choice()
			.when().simple("${body.empresa} == 'adidas'")
				.marshal(new JacksonDataFormat(Pedido.class))
				.to("activemq:activemq-empresa-adidas")
			.when().simple("${body.empresa} == 'fila'")
				.marshal(new JacksonDataFormat(Pedido.class))
				.to("activemq:activemq-empresa-fila")
			.when().simple("${body.empresa} == 'puma'")
				.marshal(new JacksonDataFormat(Pedido.class))
				.to("activemq:activemq-empresa-puma")
			.otherwise()
				.marshal(new JacksonDataFormat(Pedido.class))
				.to("activemq:DeadLetterQueue")
		.endChoice()
		.end();
		 
		 
	 }
}
