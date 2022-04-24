package com.iplacex.microservices.camelproducer.b.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Parametros")
@Data
public class Parametro {
	@Id
	public String id;
	
	public String empresa;
	
	public String infoAdicional;
	

	public Parametro(String empresa, String infoAdicional) {
		this.empresa = empresa;
		this.infoAdicional = infoAdicional;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
}
