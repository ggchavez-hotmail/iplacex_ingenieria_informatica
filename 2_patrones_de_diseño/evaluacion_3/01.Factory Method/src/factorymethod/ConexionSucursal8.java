package factorymethod;

public class ConexionSucursal8 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 8");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 8");
    }

}
