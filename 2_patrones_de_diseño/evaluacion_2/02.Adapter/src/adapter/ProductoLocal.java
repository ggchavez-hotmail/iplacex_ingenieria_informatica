package adapter;

public class ProductoLocal extends Producto {

    public ProductoLocal() {
        super();
    }

    @Override
    public String obtenerPrecio(int idProducto) {
        return "$ 1.000";
    }

}
