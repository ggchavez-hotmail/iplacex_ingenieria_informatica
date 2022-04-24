package com.iplacex.microservices.camelconsumer.b.model;

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
@JsonPropertyOrder({
    "id",
    "empresa",
    "detalle",
    "realizado"
})
@Generated("jsonschema2pojo")
public class Pedido {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("empresa")
    private String empresa;
    @JsonProperty("detalle")
    private String detalle;
    @JsonProperty("realizado")
    private Boolean realizado;
    @JsonProperty("dataAdicional")
    private String dataAdicional;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("empresa")
    public String getEmpresa() {
        return empresa;
    }

    @JsonProperty("empresa")
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @JsonProperty("detalle")
    public String getDetalle() {
        return detalle;
    }

    @JsonProperty("detalle")
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @JsonProperty("realizado")
    public Boolean getRealizado() {
        return realizado;
    }

    @JsonProperty("realizado")
    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    @JsonProperty("dataAdicional")
    public String getDataAdicional() {
        return dataAdicional;
    }

    @JsonProperty("dataAdicional")
    public void setDataAdicional(String dataAdicional) {
        this.dataAdicional = dataAdicional;
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
