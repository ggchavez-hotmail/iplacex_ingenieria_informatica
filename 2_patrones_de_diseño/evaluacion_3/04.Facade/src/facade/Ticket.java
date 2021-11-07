package facade;

public class Ticket {

    public void obtenerInfo(int idSubDepartamento) {
        System.out.println("Informacion relacionada al SubDepartamento" + idSubDepartamento);
    }

    public void obtenerTotalDiario(int idSubDepartamento) {
        Persistencia totalTicket = new Persistencia();
        System.out.println("Total Ticket Diario: " + totalTicket.totalDiario(idSubDepartamento));

    }

    public void obtenerTotalSemanal(int idSubDepartamento) {
        Persistencia totalTicket = new Persistencia();
        System.out.println("Total Ticket Semanal: " + totalTicket.totalSemanal(idSubDepartamento));

    }

    public void obtenerTotalMensual(int idSubDepartamento) {
        Persistencia totalTicket = new Persistencia();
        System.out.println("Total Ticket Mensual: " + totalTicket.totalMensual(idSubDepartamento));

    }
}
