
package com.iplacex.microservices.camelconsumer.c.model;

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
@JsonPropertyOrder({ "empresaRut", "empresaNombre", "fechaInforme", "moneda", "tipoIndicador",
	"monto", "canal"})
@Generated("jsonschema2pojo")
public class DTODatosFinancieros {

	@JsonProperty("empresaRut")
	private String empresaRut;
	@JsonProperty("empresaNombre")
	private String empresaNombre;
	@JsonProperty("fechaInforme")
	private String fechaInforme;
	@JsonProperty("moneda")
	private String moneda;
	@JsonProperty("tipoIndicador")
	private String tipoIndicador;
	@JsonProperty("monto")
	private Integer monto;
	@JsonProperty("canal")
	private String canal;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("empresaRut")
	public String getEmpresaRut() {
		return empresaRut;
	}

	@JsonProperty("empresaRut")
	public void setEmpresaRut(String empresaRut) {
		this.empresaRut = empresaRut;
	}

	@JsonProperty("empresaNombre")
	public String getEmpresaNombre() {
		return empresaNombre;
	}

	@JsonProperty("empresaNombre")
	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}

	@JsonProperty("fechaInforme")
	public String getFechaInforme() {
		return fechaInforme;
	}

	@JsonProperty("fechaInforme")
	public void setFechaInforme(String fechaInforme) {
		this.fechaInforme = fechaInforme;
	}

	@JsonProperty("moneda")
	public String getMoneda() {
		return moneda;
	}

	@JsonProperty("moneda")
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@JsonProperty("tipoIndicador")
	public String getTipoIndicador() {
		return tipoIndicador;
	}

	@JsonProperty("tipoIndicador")
	public void setTipoIndicador(String tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	@JsonProperty("monto")
	public Integer getMonto() {
		return monto;
	}

	@JsonProperty("monto")
	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	@JsonProperty("canal")
	public String getCanal() {
		return canal;
	}

	@JsonProperty("canal")
	public void setCanal(String canal) {
		this.canal = canal;
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