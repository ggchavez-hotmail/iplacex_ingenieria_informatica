package factorymethod;

public class ConexionFabrica {
    public IConector getConector(String opcion) {
        if (opcion.equalsIgnoreCase("SucursalesActuales")) {
            return new ConexionActual();
        } else {
            return new ConexionFutura();
        }
    }
}
