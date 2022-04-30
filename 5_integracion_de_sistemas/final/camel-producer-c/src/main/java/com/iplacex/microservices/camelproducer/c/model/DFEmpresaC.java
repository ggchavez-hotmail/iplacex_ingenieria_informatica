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
@JsonPropertyOrder({ "id", "rutSDV", "fec", "mon", "mto", "tipInd", "procesado" })
@Generated("jsonschema2pojo")
public class DFEmpresaC {

	@JsonProperty("id")
	private String id;
	@JsonProperty("rutSDV")
	private String rutSDV;
	@JsonProperty("fec")
	private String fec;
	@JsonProperty("mon")
	private String mon;
	@JsonProperty("mto")
	private Integer mto;
	@JsonProperty("tipInd")
	private String tipInd;
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

	@JsonProperty("rutSDV")
	public String getRutSDV() {
		return rutSDV;
	}

	@JsonProperty("rutSDV")
	public void setRutSDV(String rutSDV) {
		this.rutSDV = rutSDV;
	}

	@JsonProperty("fec")
	public String getFec() {
		return fec;
	}

	@JsonProperty("fec")
	public void setFec(String fec) {
		this.fec = fec;
	}

	@JsonProperty("mon")
	public String getMon() {
		return mon;
	}

	@JsonProperty("mon")
	public void setMon(String mon) {
		this.mon = mon;
	}

	@JsonProperty("mto")
	public Integer getMto() {
		return mto;
	}

	@JsonProperty("mto")
	public void setMto(Integer mto) {
		this.mto = mto;
	}

	@JsonProperty("tipInd")
	public String getTipInd() {
		return tipInd;
	}

	@JsonProperty("tipInd")
	public void setTipInd(String tipInd) {
		this.tipInd = tipInd;
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