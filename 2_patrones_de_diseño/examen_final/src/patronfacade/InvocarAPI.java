package patronfacade;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.glassfish.jersey.client.ClientConfig;

import modelo.SCex;
import modelo.Sipen;
import modelo.Slafi;
import patronproxy.Usuario;

public class InvocarAPI {
    // http://localhost:3000/
    // Slafi
    public List<Slafi> invocarAPISlafi(String url, String metodo) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(url);
        List<Slafi> respuesta = target.path(metodo).request().accept("application/json")
                .get(new GenericType<List<Slafi>>() {
                });
        client.close();
        return respuesta;
    }

    // http://localhost:3000/
    // SCex
    public List<SCex> invocarAPISCex(String url, String metodo) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(url);
        List<SCex> respuesta = target.path(metodo).request().accept("application/json")
                .get(new GenericType<List<SCex>>() {
                });
        client.close();
        return respuesta;
    }

    // http://localhost:3000/
    // Sipen
    public List<Sipen> invocarAPISipen(String url, String metodo) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(url);
        List<Sipen> respuesta = target.path(metodo).request().accept("application/json")
                .get(new GenericType<List<Sipen>>() {
                });
        client.close();
        return respuesta;
    }

    // http://localhost:3000/
    // Usuarios
    // nombre
    // password
    public List<Usuario> invocarAPIUsuarios(String url, String metodo, String nombre, String password) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(url);
        List<Usuario> respuesta = target.path(metodo).queryParam("nombre", nombre).queryParam("password", password)
                .request().accept("application/json").get(new GenericType<List<Usuario>>() {
                });
        client.close();
        return respuesta;
    }

    public String validarUsuario(List<Usuario> usuarios) {
        String respuesta = "False";

        for (Usuario item : usuarios) {
            respuesta = item.getHabilitado();
        }

        return respuesta;
    }

}
