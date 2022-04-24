package com.iplacex.microservices.camelconsumer.b.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

import com.iplacex.microservices.camelconsumer.b.model.Pedido;
import com.iplacex.microservices.camelconsumer.b.model.PedidoEmpresaA;
import com.iplacex.microservices.camelconsumer.b.model.PedidoEmpresaB;
import com.iplacex.microservices.camelconsumer.b.model.PedidoEmpresaC;

@Component
public class ActiveMQReceiverRoute extends RouteBuilder{
	
	@Override
	public void configure() throws Exception{
		//lectura de cola empresa adidas
		from("activemq:activemq-empresa-adidas")
		.to("log:activemq-empresa-adidas")
		.unmarshal(new JacksonDataFormat(Pedido.class))
		.log("${body}")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.POST))		
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.process(exchange->{
			//Se rescata de base de datos los parametros adicionales
			Pedido pedido = exchange.getIn().getBody(Pedido.class);
			if(pedido != null) {
				PedidoEmpresaA pedidoEmpresa = new PedidoEmpresaA();
				pedidoEmpresa.setId(pedido.getId());
				pedidoEmpresa.setPedido(pedido.getDetalle());
				pedidoEmpresa.setDatos(pedido.getDataAdicional());				
				exchange.getOut().setBody(pedidoEmpresa);
			}
		})
		.marshal(new JacksonDataFormat(PedidoEmpresaA.class))
		.to("http://127.0.0.1:3001/empresaAdidas")		
		.end();
		
		//lectura de cola empresa fila
		from("activemq:activemq-empresa-fila")
		.to("log:activemq-empresa-fila")
		.unmarshal(new JacksonDataFormat(Pedido.class))
		.log("${body}")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.POST))		
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.process(exchange->{
			//Se rescata de base de datos los parametros adicionales
			Pedido pedido = exchange.getIn().getBody(Pedido.class);
			if(pedido != null) {
				PedidoEmpresaB pedidoEmpresa = new PedidoEmpresaB();
				pedidoEmpresa.setId(pedido.getId());
				pedidoEmpresa.setDetalle(pedido.getDetalle());
				pedidoEmpresa.setData(pedido.getDataAdicional());				
				exchange.getOut().setBody(pedidoEmpresa);
			}
		})
		.marshal(new JacksonDataFormat(PedidoEmpresaB.class))
		.to("http://127.0.0.1:3002/empresaFila")
		.end();
		
		//lectura de cola empresa puma
		from("activemq:activemq-empresa-puma")
		.to("log:activemq-empresa-puma")
		.unmarshal(new JacksonDataFormat(Pedido.class))
		.log("${body}")
		.setHeader(Exchange.HTTP_METHOD,constant(org.apache.camel.component.http.HttpMethods.POST))		
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.process(exchange->{
			//Se rescata de base de datos los parametros adicionales
			Pedido pedido = exchange.getIn().getBody(Pedido.class);
			if(pedido != null) {
				PedidoEmpresaC pedidoEmpresa = new PedidoEmpresaC();
				pedidoEmpresa.setId(pedido.getId());
				pedidoEmpresa.setDetalles(pedido.getDetalle());
				pedidoEmpresa.setDataAdicional(pedido.getDataAdicional());				
				exchange.getOut().setBody(pedidoEmpresa);
			}
		})
		.marshal(new JacksonDataFormat(PedidoEmpresaC.class))
		.to("http://127.0.0.1:3003/empresaPuma")
		.end();
	}
}
