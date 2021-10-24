package observer;

public class Cliente extends Observador {

    public Cliente(Despacho despacho) {
        this.despacho = despacho;
        this.despacho.agregar(this);
    }

    @Override
    public void actualizar() {
        String estado = despacho.getEstado();
        System.out.println("Cambio estado Cliente: " + estado);

        if (estado == "Preparado") {
            System.out.println(" ---> Notificar al cliente fecha entrega: 30/10/2021");
        }
    }

}
