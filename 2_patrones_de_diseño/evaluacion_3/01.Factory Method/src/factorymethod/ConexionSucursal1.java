package factorymethod;

public class ConexionSucursal1 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 1");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta de Sucursal 1");
    }

}
