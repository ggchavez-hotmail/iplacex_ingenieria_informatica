package com.iplacex.microservices.camelproducer.c.routes.emp;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducer.c.model.Parametro;
import com.iplacex.microservices.camelproducer.c.model.DFEmpresaB;
import com.iplacex.microservices.camelproducer.c.model.DatosFinancieros;
import com.iplacex.microservices.camelproducer.c.repository.ParametroRepo;

@Component
public class ConsumirRestRouterEmpB extends RouteBuilder{
	
	@Autowired
	ParametroRepo parametroRepo;
	
	//private DFEmpresaB empresaB;
	
	//private DatosFinancieros datosFinancieros;
	
	@Override
	public void configure() throws Exception {
		onException(Exception.class)
		.log("Este es el mensaje de Error: ${exception}");
		
		//Se genera un timer para consultar end-point
		//que devuelve los pedidos pendiente de realizar
		from("timer:simple?period=551000")
		.log("--- iniciar proceso ---")
		.to("direct:consumirWSRestGETEmpB")
		.end();
		
		//Consulta end-point de pedidos existentes
		from("direct:consumirWSRestGETEmpB")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.GET))
		.to("http://127.0.0.1:3002/empresaB?procesado=false")
		.log("Recuperar via get los Datos Financieros Empresa B")
		.unmarshal(new ListJacksonDataFormat(DFEmpresaB.class))
		.setBody(simple("${body}"))
		.log("${body}")
		.choice()
			.when(body().isNotNull())
				.split(body())
					.log("Procesar contenido")
					.process(exchange->{
						//Se rescata de base de datos los parametros adicionales
						DFEmpresaB empresaAIn = exchange.getIn().getBody(DFEmpresaB.class);
						DatosFinancieros datosFinancieros = new DatosFinancieros();
						
						if(empresaAIn != null) {
							System.out.println("... procesando Pedido ID "+ empresaAIn.getId());
							System.out.println("... procesando Pedido RUT "+ empresaAIn.getRutEmp());
							datosFinancieros.setId(empresaAIn.getId());
							datosFinancieros.setEmpresaRut(empresaAIn.getRutEmp());
							datosFinancieros.setFechaInforme(empresaAIn.getFecEmp());
							datosFinancieros.setInformeProcesado(empresaAIn.getProcesado());
							datosFinancieros.setMoneda(empresaAIn.getMoneda());
							datosFinancieros.setMonto(empresaAIn.getMonto());
							datosFinancieros.setTipoIndicador(empresaAIn.getTipoIndicador());
							datosFinancieros.setEmpresaVigente(false);
							datosFinancieros.setCanal("EmpB");

							System.out.println("... recuperar parametros");
							List<Parametro> parametros = parametroRepo.findAllByRut(empresaAIn.getRutEmp());
							
							if(parametroRepo != null) {			
								for (Parametro parametro : parametros) {
									datosFinancieros.setEmpresaNombre(parametro.getNombre());	
									datosFinancieros.setEmpresaVigente(parametro.getVigente());	
								}
							}
							//empresaB.setProcesado(true);
							exchange.getOut().setBody(datosFinancieros);
						}
					})
					.log("... fin Procesar contenido")
					.to("direct:consumirWSRestPUTEmpB")
		.endChoice()
		.end();
		
		//Proceso que actualiza el registro
		from("direct:consumirWSRestPUTEmpB")
		//.transform().constant(datosFinancieros)
		.log("---> hacia cola")
		.to("direct:dejarMsgQueue")
		.log("regreso <---")
		.log("${body}")
		.unmarshal(new JacksonDataFormat(DatosFinancieros.class))
		.process(exchange->{
			DatosFinancieros datosFinancieros = exchange.getIn().getBody(DatosFinancieros.class);
			DFEmpresaB empresaAOut = new DFEmpresaB();
			System.out.println("actualziar Pedido ID "+ datosFinancieros.getId());
			empresaAOut.setId(datosFinancieros.getId());
			empresaAOut.setProcesado(true);			
			exchange.getOut().setBody(empresaAOut);
			})
		//.transform().constant(empresaB)
		//.log("${body.id}")
		//.log("${body.rut}")
		.log("actualizar estatus via Rest PUT")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.PATCH))
		.setHeader(Exchange.HTTP_PATH, simple("/${body.id}"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.marshal(new JacksonDataFormat(DFEmpresaB.class))
		.to("http://127.0.0.1:3002/empresaB")		
		.end();
			 
	 }
}
