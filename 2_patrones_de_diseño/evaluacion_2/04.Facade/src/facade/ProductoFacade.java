package facade;

public class ProductoFacade {
    public void obtenerInformacion(int idProducto) {
        Producto pro = new Producto();

        pro.obtenerInfo(idProducto);
        pro.obtenerStockLegado(idProducto);
    }
}
