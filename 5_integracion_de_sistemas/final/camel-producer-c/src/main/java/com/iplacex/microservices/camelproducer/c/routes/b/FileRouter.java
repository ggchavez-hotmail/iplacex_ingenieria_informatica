package com.iplacex.microservices.camelproducer.c.routes.b;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducer.c.model.Parametro;
import com.iplacex.microservices.camelproducer.c.model.DFArchivo;
import com.iplacex.microservices.camelproducer.c.model.DatosFinancieros;
import com.iplacex.microservices.camelproducer.c.repository.ParametroRepo;

@Component
public class FileRouter extends RouteBuilder{
	@Autowired
	ParametroRepo parametroRepo;

	//private DatosFinancieros datosFinancieros;
	
	@Override
	public void configure() throws Exception {
		onException(Exception.class)
		.log("Este es el mensaje de Error: ${exception}");
		
		from("file:files/input")		
		//.log("${body}")		
		.to("file:files/output")
		.log("Recuperar via archivos dejados en directorio")
		.unmarshal(new ListJacksonDataFormat(DFArchivo.class))
		.setBody(simple("${body}"))
		.choice()
			.when(body().isNotNull())
				.split(body())
					.log("Procesar contenido")
					.process(exchange->{
						//Se rescata de base de datos los parametros adicionales
						DFArchivo empresa = exchange.getIn().getBody(DFArchivo.class);
						
						DatosFinancieros datosFinancieros = new DatosFinancieros();
						if(empresa != null) {
							System.out.println("... procesando Pedido ID "+ empresa.getId());
							System.out.println("... procesando Pedido RUT "+ empresa.getRut());
							datosFinancieros.setId(empresa.getId());
							datosFinancieros.setEmpresaRut(empresa.getRut());
							datosFinancieros.setFechaInforme(empresa.getFecha());
							datosFinancieros.setInformeProcesado(false);
							datosFinancieros.setMoneda(empresa.getMoneda());
							datosFinancieros.setMonto(empresa.getMonto());
							datosFinancieros.setTipoIndicador(empresa.getTipoIndicador());
							datosFinancieros.setEmpresaVigente(false);
							datosFinancieros.setCanal("File");

							System.out.println("... recuperar parametros");
							List<Parametro> parametros = parametroRepo.findAllByRut(empresa.getRut());
							
							if(parametroRepo != null) {			
								for (Parametro parametro : parametros) {
									datosFinancieros.setEmpresaNombre(parametro.getNombre());	
									datosFinancieros.setEmpresaVigente(parametro.getVigente());	
									
								}
							}
							exchange.getOut().setBody(datosFinancieros);
						}
					})
					//.transform().constant(datosFinancieros)
					.log("---> hacia cola")
					.to("direct:dejarMsgQueue")
					.log("regreso <---")
		.endChoice()
		.end();
	}
}
