package com.iplacex.microservices.camelproducer.b.routes.b;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducer.b.model.Parametro;
import com.iplacex.microservices.camelproducer.b.model.Pedido;
import com.iplacex.microservices.camelproducer.b.repository.ParametroRepo;

@Component
public class FileRouter extends RouteBuilder{
	@Autowired
	ParametroRepo parametroRepo;
	
	@Override
	public void configure() throws Exception {
		from("file:files/input")		
		//.log("${body}")		
		.to("file:files/output")
		.log("Recuperar via archivos dejados en directorio")
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
					.to("direct:dejarMsgQueue")
		.endChoice()
		.end();
	}
}
