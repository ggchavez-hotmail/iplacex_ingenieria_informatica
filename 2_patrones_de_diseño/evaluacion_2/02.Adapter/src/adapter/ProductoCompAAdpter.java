package adapter;

public class ProductoCompAAdpter extends Producto {
    private ProductoCompA prodCompA;

    public ProductoCompAAdpter() {
        super();
        this.prodCompA = new ProductoCompA();
    }

    @Override
    public String obtenerPrecio(int idProducto) {
        return this.prodCompA.recuperarPrecioSoap(idProducto);
    }
	
}
