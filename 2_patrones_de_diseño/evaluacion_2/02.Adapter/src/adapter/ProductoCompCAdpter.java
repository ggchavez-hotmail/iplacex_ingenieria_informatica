package adapter;

public class ProductoCompCAdpter extends Producto {
    private ProductoCompC prodCompC;

    public ProductoCompCAdpter() {
        super();
        this.prodCompC = new ProductoCompC();
    }

    @Override
    public String obtenerPrecio(int idProducto) {
        return this.prodCompC.DevolverPrecioPrecio(idProducto);
    }
}
