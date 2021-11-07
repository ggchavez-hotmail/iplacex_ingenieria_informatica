package observer;

public class App {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Sistema(ticket);

        System.out.println("--------------------------");
        ticket.setEstado("Creado");
        System.out.println("--------------------------");
        ticket.setEstado("Entregado");
        System.out.println("--------------------------");
    }
}
