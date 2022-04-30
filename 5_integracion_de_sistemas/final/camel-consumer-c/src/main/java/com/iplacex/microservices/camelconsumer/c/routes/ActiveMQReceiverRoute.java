package com.iplacex.microservices.camelconsumer.c.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelconsumer.c.model.DTODatosFinancieros;
import com.iplacex.microservices.camelconsumer.c.model.DatosFinancieros;


@Component
public class ActiveMQReceiverRoute extends RouteBuilder{

	private DatosFinancieros datosFinancieros = new DatosFinancieros();
	
	private DTODatosFinancieros dtoDatosFinancieros = new DTODatosFinancieros();
	
	@Override
	public void configure() throws Exception{
		onException(Exception.class)
		.log("Este es el mensaje de Error: ${exception}");
		
		//lectura de cola empresa adidas
		from("activemq:activemq-datos-financieros")
		.to("log:activemq-datos-financieros")
		.unmarshal(new JacksonDataFormat(DatosFinancieros.class))
		.log("${body}")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.POST))		
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.process(exchange->{
			//Se rescata de base de datos los parametros adicionales
			datosFinancieros = exchange.getIn().getBody(DatosFinancieros.class);
			
			if(datosFinancieros != null) {
				//dtoDatosFinancieros.setId(datosFinancieros.getId()); //este dato se autogenera
				dtoDatosFinancieros.setEmpresaRut(datosFinancieros.getEmpresaRut());
				dtoDatosFinancieros.setEmpresaNombre(datosFinancieros.getEmpresaNombre());
				dtoDatosFinancieros.setMoneda(datosFinancieros.getMoneda());
				dtoDatosFinancieros.setMonto(datosFinancieros.getMonto());
				dtoDatosFinancieros.setTipoIndicador(datosFinancieros.getTipoIndicador());
				dtoDatosFinancieros.setCanal(datosFinancieros.getCanal());
						
				//exchange.getOut().setBody(dtoDatosFinancieros);
			}
		})
		.transform().constant(dtoDatosFinancieros)
		.log("${body}")
		.marshal(new JacksonDataFormat(DTODatosFinancieros.class))
		.to("http://127.0.0.1:3000/sistema")		
		.end();
		
	}
}
