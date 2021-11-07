package facade;

public class TicketFacade {
    public void obtenerInformacionDepartamentos() {
        Ticket ticket = new Ticket();

        for (int i = 1; i < 7; i++) {

            ticket.obtenerInfo(i);
            ticket.obtenerTotalDiario(i);
            ticket.obtenerTotalSemanal(i);
            ticket.obtenerTotalMensual(i);
        }

    }
}
