package observer;

import java.util.List;
import java.util.ArrayList;

public class Ticket {
    private List<Observador> observadores = new ArrayList<Observador>();
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public void agregar(Observador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores() {
        observadores.forEach(x -> x.actualizar());
    }
}
