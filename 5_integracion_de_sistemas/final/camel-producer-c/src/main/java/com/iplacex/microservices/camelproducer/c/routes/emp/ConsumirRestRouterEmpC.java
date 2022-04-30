package com.iplacex.microservices.camelproducer.c.routes.emp;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelproducer.c.model.Parametro;
import com.iplacex.microservices.camelproducer.c.model.DFEmpresaC;
import com.iplacex.microservices.camelproducer.c.model.DatosFinancieros;
import com.iplacex.microservices.camelproducer.c.repository.ParametroRepo;

@Component
public class ConsumirRestRouterEmpC extends RouteBuilder{
	
	@Autowired
	ParametroRepo parametroRepo;
	
	//private DFEmpresaC empresaC;
	
	//private DatosFinancieros datosFinancieros;
	
	@Override
	public void configure() throws Exception {
		onException(Exception.class)
		.log("Este es el mensaje de Error: ${exception}");
		
		//Se genera un timer para consultar end-point
		//que devuelve los pedidos pendiente de realizar
		from("timer:simple?period=551000")
		.log("--- iniciar proceso ---")
		.to("direct:consumirWSRestGETEmpC")
		.end();
		
		//Consulta end-point de pedidos existentes
		from("direct:consumirWSRestGETEmpC")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.GET))
		.to("http://127.0.0.1:3003/empresaC?procesado=false")
		.log("Recuperar via get los Datos Financieros Empresa B")
		.unmarshal(new ListJacksonDataFormat(DFEmpresaC.class))
		.setBody(simple("${body}"))
		.log("${body}")
		.choice()
			.when(body().isNotNull())
				.split(body())
					.log("Procesar contenido")
					.process(exchange->{
						//Se rescata de base de datos los parametros adicionales
						DFEmpresaC empresaAIn = exchange.getIn().getBody(DFEmpresaC.class);
						DatosFinancieros datosFinancieros = new DatosFinancieros();
						
						if(empresaAIn != null) {
							System.out.println("... procesando Pedido ID "+ empresaAIn.getId());
							System.out.println("... procesando Pedido RUT "+ empresaAIn.getRutSDV());
							datosFinancieros.setId(empresaAIn.getId());
							datosFinancieros.setEmpresaRut(empresaAIn.getRutSDV());
							datosFinancieros.setFechaInforme(empresaAIn.getFec());
							datosFinancieros.setInformeProcesado(empresaAIn.getProcesado());
							datosFinancieros.setMoneda(empresaAIn.getMon());
							datosFinancieros.setMonto(empresaAIn.getMto());
							datosFinancieros.setTipoIndicador(empresaAIn.getTipInd());
							datosFinancieros.setEmpresaVigente(false);
							datosFinancieros.setCanal("EmpC");

							System.out.println("... recuperar parametros");
							List<Parametro> parametros = parametroRepo.findAllByRut(empresaAIn.getRutSDV());
							
							if(parametroRepo != null) {			
								for (Parametro parametro : parametros) {
									datosFinancieros.setEmpresaNombre(parametro.getNombre());	
									datosFinancieros.setEmpresaVigente(parametro.getVigente());	
								}
							}
							//empresaC.setProcesado(true);
							exchange.getOut().setBody(datosFinancieros);
						}
					})
					.log("... fin Procesar contenido")
					.to("direct:consumirWSRestPUTEmpC")
		.endChoice()
		.end();
		
		//Proceso que actualiza el registro
		from("direct:consumirWSRestPUTEmpC")
		//.transform().constant(datosFinancieros)
		.log("---> hacia cola")
		.to("direct:dejarMsgQueue")
		.log("regreso <---")
		.log("${body}")
		.unmarshal(new JacksonDataFormat(DatosFinancieros.class))
		.process(exchange->{
			DatosFinancieros datosFinancieros = exchange.getIn().getBody(DatosFinancieros.class);
			DFEmpresaC empresaAOut = new DFEmpresaC();
			System.out.println("actualziar Pedido ID "+ datosFinancieros.getId());
			empresaAOut.setId(datosFinancieros.getId());
			empresaAOut.setProcesado(true);			
			exchange.getOut().setBody(empresaAOut);
			})
		//.transform().constant(empresaC)
		//.log("${body.id}")
		//.log("${body.rut}")
		.log("actualizar estatus via Rest PUT")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.PATCH))
		.setHeader(Exchange.HTTP_PATH, simple("/${body.id}"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.marshal(new JacksonDataFormat(DFEmpresaC.class))
		.to("http://127.0.0.1:3003/empresaC")		
		.end();
			 
	 }
}
