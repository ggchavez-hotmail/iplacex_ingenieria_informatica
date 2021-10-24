package factorymethod;

public class App {
    public static void main(String[] args) {
        ConexionFabrica conex = new ConexionFabrica();

        System.out.println("--------------------------");
        IConector connAct = conex.getConector("SucursalesActuales");
        connAct.conectar();
        connAct.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector connFut = conex.getConector("SucursalesFuturas");
        connFut.conectar();
        connFut.desconectar();
        System.out.println("--------------------------");

    }
}
