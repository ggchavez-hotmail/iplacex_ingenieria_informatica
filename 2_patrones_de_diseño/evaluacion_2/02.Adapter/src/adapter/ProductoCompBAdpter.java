package adapter;

public class ProductoCompBAdpter extends Producto {
    private ProductoCompB prodCompB;

    public ProductoCompBAdpter() {
        super();
        this.prodCompB = new ProductoCompB();
    }

    @Override
    public String obtenerPrecio(int idProducto) {
        return this.prodCompB.RecuperarPrecioRest(Integer.toString(idProducto));
    }
}
