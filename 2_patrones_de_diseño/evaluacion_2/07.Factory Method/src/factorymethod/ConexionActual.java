package factorymethod;

public class ConexionActual implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a 3 sucursales");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a 3 sucursales");
    }

}
