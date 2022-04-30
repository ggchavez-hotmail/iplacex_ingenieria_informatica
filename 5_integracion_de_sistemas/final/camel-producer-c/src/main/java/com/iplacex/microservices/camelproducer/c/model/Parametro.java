package com.iplacex.microservices.camelproducer.c.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Parametros")

@Data
public class Parametro {
	@Id
	private String id;
	
	private String rut;
	private String nombre;
	private Boolean vigente;
	
	public Parametro(String rut, String nombre, Boolean vigente) {
		this.rut = rut;
		this.nombre = nombre;
		this.vigente = vigente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	
}

