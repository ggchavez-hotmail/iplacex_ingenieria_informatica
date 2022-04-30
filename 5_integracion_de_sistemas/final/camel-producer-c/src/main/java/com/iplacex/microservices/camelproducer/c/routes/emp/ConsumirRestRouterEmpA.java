package com.iplacex.microservices.camelproducer.c.routes.emp;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducer.c.model.Parametro;
import com.iplacex.microservices.camelproducer.c.model.DFEmpresaA;
import com.iplacex.microservices.camelproducer.c.model.DatosFinancieros;
import com.iplacex.microservices.camelproducer.c.repository.ParametroRepo;

@Component
public class ConsumirRestRouterEmpA extends RouteBuilder{
	
	@Autowired
	ParametroRepo parametroRepo;
	
	//private DFEmpresaA empresaA;
	
	//private DatosFinancieros datosFinancieros;
	
	@Override
	public void configure() throws Exception {
		onException(Exception.class)
		.log("Este es el mensaje de Error: ${exception}");
		
		
		//Se genera un timer para consultar end-point
		//que devuelve los pedidos pendiente de realizar
		from("timer:simple?period=551000")
		.log("--- iniciar proceso ---")
		.to("direct:consumirWSRestGETEmpA")
		.end();
		
		//Consulta end-point de pedidos existentes
		from("direct:consumirWSRestGETEmpA")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.GET))
		.to("http://127.0.0.1:3001/empresaA?informeProcesado=false")
		.log("Recuperar via get los Datos Financieros Empresa A")
		.unmarshal(new ListJacksonDataFormat(DFEmpresaA.class))
		.setBody(simple("${body}"))
		.log("${body}")
		.choice()
			.when(body().isNotNull())
				.split(body())
					.log("Procesar contenido")
					.process(exchange->{
						//Se rescata de base de datos los parametros adicionales
						DFEmpresaA empresaAIn = exchange.getIn().getBody(DFEmpresaA.class);
						DatosFinancieros datosFinancieros = new DatosFinancieros();
						
						if(empresaAIn != null) {
							System.out.println("... procesando Pedido ID "+ empresaAIn.getId());
							System.out.println("... procesando Pedido RUT "+ empresaAIn.getRut());
							datosFinancieros.setId(empresaAIn.getId());
							datosFinancieros.setEmpresaRut(empresaAIn.getRut());
							datosFinancieros.setFechaInforme(empresaAIn.getFecha());
							datosFinancieros.setInformeProcesado(empresaAIn.getInformeProcesado());
							datosFinancieros.setMoneda(empresaAIn.getMoneda());
							datosFinancieros.setMonto(empresaAIn.getMonto());
							datosFinancieros.setTipoIndicador(empresaAIn.getTipoIndicador());
							datosFinancieros.setEmpresaVigente(false);
							datosFinancieros.setCanal("EmpA");

							System.out.println("... recuperar parametros");
							List<Parametro> parametros = parametroRepo.findAllByRut(empresaAIn.getRut());
							
							if(parametroRepo != null) {			
								for (Parametro parametro : parametros) {
									datosFinancieros.setEmpresaNombre(parametro.getNombre());	
									datosFinancieros.setEmpresaVigente(parametro.getVigente());	
								}
							}
							//empresaA.setInformeProcesado(true);
							exchange.getOut().setBody(datosFinancieros);
						}
					})
					.log("... fin Procesar contenido")
					.to("direct:consumirWSRestPUTEmpA")
		.endChoice()
		.end();
		
		//Proceso que actualiza el registro
		from("direct:consumirWSRestPUTEmpA")
		//.transform().constant(datosFinancieros)
		.log("---> hacia cola")
		.to("direct:dejarMsgQueue")
		.log("regreso <---")
		.log("${body}")
		.unmarshal(new JacksonDataFormat(DatosFinancieros.class))
		.process(exchange->{
			DatosFinancieros datosFinancieros = exchange.getIn().getBody(DatosFinancieros.class);
			DFEmpresaA empresaAOut = new DFEmpresaA();
			System.out.println("actualziar Pedido ID "+ datosFinancieros.getId());
			empresaAOut.setId(datosFinancieros.getId());
			empresaAOut.setInformeProcesado(true);			
			exchange.getOut().setBody(empresaAOut);
			})
		//.transform().constant(empresaA)
		//.log("${body.id}")
		//.log("${body.rut}")
		.log("actualizar estatus via Rest PUT")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.PATCH))
		.setHeader(Exchange.HTTP_PATH, simple("/${body.id}"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.marshal(new JacksonDataFormat(DFEmpresaA.class))
		.to("http://127.0.0.1:3001/empresaA")		
		.end();
			 
	 }
}
