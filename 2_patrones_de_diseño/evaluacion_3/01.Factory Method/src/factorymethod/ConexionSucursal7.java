package factorymethod;

public class ConexionSucursal7 implements IConector {

    @Override
    public void conectar() {
        System.out.println("Se conecta a Sucursal 7");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconecta a Sucursal 7");
    }

}
