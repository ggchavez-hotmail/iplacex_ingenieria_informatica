package observer;

public class Sistema extends Observador {

    public Sistema(Despacho despacho) {
        this.despacho = despacho;
        this.despacho.agregar(this);
    }

    @Override
    public void actualizar() {
        String estado = despacho.getEstado();
        System.out.println("Cambio estado Sistema: " + estado);

        if (estado == "Entregado") {
            System.out.println(" ---> Actualizar Estado en Sistema.");
        }
    }

}
