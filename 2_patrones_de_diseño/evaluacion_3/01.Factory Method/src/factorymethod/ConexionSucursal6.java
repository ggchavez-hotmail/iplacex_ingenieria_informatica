package factorymethod;

public class ConexionSucursal6 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 6");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 6");
    }

}
