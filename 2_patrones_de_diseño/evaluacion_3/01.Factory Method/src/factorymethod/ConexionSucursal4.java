package factorymethod;

public class ConexionSucursal4 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 4");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 4");
    }

}
