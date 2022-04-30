package com.iplacex.microservices.camelproducer.c.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "rutEmp", "fechaEmp", "tipoMoneda", "monto", "tipoIndicador", "informeProcesado" })
@Generated("jsonschema2pojo")
public class DFEmpresaA {

	@JsonProperty("id")
	private String id;
	@JsonProperty("rut")
	private String rut;
	@JsonProperty("fecha")
	private String fecha;
	@JsonProperty("moneda")
	private String moneda;
	@JsonProperty("monto")
	private Integer monto;
	@JsonProperty("tipoIndicador")
	private String tipoIndicador;
	@JsonProperty("informeProcesado")
	private Boolean informeProcesado;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("rut")
	public String getRut() {
		return rut;
	}

	@JsonProperty("rut")
	public void setRut(String rut) {
		this.rut = rut;
	}

	@JsonProperty("fecha")
	public String getFecha() {
		return fecha;
	}

	@JsonProperty("fecha")
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@JsonProperty("moneda")
	public String getMoneda() {
		return moneda;
	}

	@JsonProperty("moneda")
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@JsonProperty("monto")
	public Integer getMonto() {
		return monto;
	}

	@JsonProperty("monto")
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	@JsonProperty("tipoIndicador")
	public String getTipoIndicador() {
		return tipoIndicador;
	}

	@JsonProperty("tipoIndicador")
	public void setTipoIndicador(String tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	@JsonProperty("informeProcesado")
	public Boolean getInformeProcesado() {
		return informeProcesado;
	}

	@JsonProperty("informeProcesado")
	public void setInformeProcesado(Boolean informeProcesado) {
		this.informeProcesado = informeProcesado;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}