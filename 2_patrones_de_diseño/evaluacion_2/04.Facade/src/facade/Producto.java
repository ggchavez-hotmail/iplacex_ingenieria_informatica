package facade;

public class Producto {

    public void obtenerInfo(int idProducto) {
        System.out.println("Informacion relacionada al producto " + idProducto);
    }

    public void obtenerStockLegado(int idProducto) {
        SistemaLegado stock = new SistemaLegado();
        System.out.println("Stock: " + stock.devolverStock(idProducto));

    }
}
