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
@JsonPropertyOrder({ "id", "rutEmp", "fecEmp", "moneda", "monto", "tipoIndicador", "procesado" })
@Generated("jsonschema2pojo")
public class DFEmpresaB {

	@JsonProperty("id")
	private String id;
	@JsonProperty("rutEmp")
	private String rutEmp;
	@JsonProperty("fecEmp")
	private String fecEmp;
	@JsonProperty("moneda")
	private String moneda;
	@JsonProperty("monto")
	private Integer monto;
	@JsonProperty("tipoIndicador")
	private String tipoIndicador;
	@JsonProperty("procesado")
	private Boolean procesado;
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

	@JsonProperty("rutEmp")
	public String getRutEmp() {
		return rutEmp;
	}

	@JsonProperty("rutEmp")
	public void setRutEmp(String rutEmp) {
		this.rutEmp = rutEmp;
	}

	@JsonProperty("fecEmp")
	public String getFecEmp() {
		return fecEmp;
	}

	@JsonProperty("fecEmp")
	public void setFecEmp(String fecEmp) {
		this.fecEmp = fecEmp;
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

	@JsonProperty("procesado")
	public Boolean getProcesado() {
		return procesado;
	}

	@JsonProperty("procesado")
	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
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