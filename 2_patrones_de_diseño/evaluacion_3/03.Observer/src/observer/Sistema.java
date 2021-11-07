package observer;

public class Sistema extends Observador {

    public Sistema(Ticket ticket) {
        this.ticket = ticket;
        this.ticket.agregar(this);
    }

    @Override
    public void actualizar() {
        String estado = ticket.getEstado();
        System.out.println("Cambio estado Sistema: " + estado);

        if (estado == "Entregado") {
            System.out.println(" ---> Actualizar Estado en Sistema.");
        }
    }

}
