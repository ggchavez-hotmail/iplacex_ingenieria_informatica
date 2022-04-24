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
    "detalles",
    "dataAdicional"
})
@Generated("jsonschema2pojo")
public class PedidoEmpresaC {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("detalles")
    private String detalles;
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

    @JsonProperty("detalles")
    public String getDetalles() {
        return detalles;
    }

    @JsonProperty("detalles")
    public void setDetalles(String detalles) {
        this.detalles = detalles;
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