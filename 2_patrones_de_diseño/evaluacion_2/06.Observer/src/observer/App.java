package observer;

public class App {
    public static void main(String[] args) {
        Despacho despacho = new Despacho();

        new Cliente(despacho);
        new Sistema(despacho);

        System.out.println("--------------------------");
        despacho.setEstado("Preparado");
        System.out.println("--------------------------");
        despacho.setEstado("Enviado");
        System.out.println("--------------------------");
        despacho.setEstado("Entregado");
        System.out.println("--------------------------");
    }
}
