package factorymethod;

public class ConexionSucursal5 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 5");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 5");
    }

}
