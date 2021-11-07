package factorymethod;

public class ConexionSucursal2 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 2");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 2");
    }

}
