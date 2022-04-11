package com.iplacex.microservices.camelconsumera.model;
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
    "pedido",
    "datos"
})
@Generated("jsonschema2pojo")
public class PedidoEmpresaA {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("pedido")
    private String pedido;
    @JsonProperty("datos")
    private String datos;
    
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

    @JsonProperty("pedido")
    public String getPedido() {
        return pedido;
    }

    @JsonProperty("pedido")
    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    @JsonProperty("datos")
    public String getDatos() {
        return datos;
    }

    @JsonProperty("datos")
    public void setDatos(String datos) {
        this.datos = datos;
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