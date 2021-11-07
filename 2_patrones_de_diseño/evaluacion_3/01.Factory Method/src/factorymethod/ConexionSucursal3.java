package factorymethod;

public class ConexionSucursal3 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 3");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 3");
    }

}
