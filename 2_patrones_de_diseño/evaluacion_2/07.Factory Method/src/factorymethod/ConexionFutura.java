package factorymethod;

public class ConexionFutura implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a sucursales nuevas");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta de sucursales nuevas");
    }

}
