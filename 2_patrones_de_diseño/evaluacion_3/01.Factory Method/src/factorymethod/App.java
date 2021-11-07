package factorymethod;

public class App {
    public static void main(String[] args) {
        ConexionFabrica conex = new ConexionFabrica();

        System.out.println("--------------------------");
        IConector conn1 = conex.getConector("Sucursal1");
        conn1.conectar();
        conn1.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn2 = conex.getConector("Sucursal2");
        conn2.conectar();
        conn2.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn3 = conex.getConector("Sucursal3");
        conn3.conectar();
        conn3.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn4 = conex.getConector("Sucursal4");
        conn4.conectar();
        conn4.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn5 = conex.getConector("Sucursal5");
        conn5.conectar();
        conn5.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn6 = conex.getConector("Sucursal6");
        conn6.conectar();
        conn6.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn7 = conex.getConector("Sucursal7");
        conn7.conectar();
        conn7.desconectar();
        System.out.println("--------------------------");

        System.out.println("--------------------------");
        IConector conn8 = conex.getConector("Sucursal8");
        conn8.conectar();
        conn8.desconectar();
        System.out.println("--------------------------");

    }
}
