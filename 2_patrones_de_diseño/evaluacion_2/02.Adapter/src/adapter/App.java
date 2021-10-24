package adapter;

public class App {
    public static void main(String[] args) {
        App producto = new App();
        int idProducto = 1;
        System.out.println("***********Precios*************");
        System.out.println("IdProducto: " + Integer.toString(idProducto));
        System.out.println("Local: " + producto.usarProductoLocal(idProducto));
        System.out.println("Competencia A: " + producto.usarProductoCompA(idProducto));
        System.out.println("Competencia B: " + producto.usarProductoCompB(idProducto));
        System.out.println("Competencia C: " + producto.usarProductoCompC(idProducto));
    }

    private String usarProductoLocal(int idProducto) {
        Producto prod = new ProductoLocal();
        return prod.obtenerPrecio(idProducto);
    }

    private String usarProductoCompA(int idProducto) {
        Producto prod = new ProductoCompAAdpter();
        return prod.obtenerPrecio(idProducto);
    }

    private String usarProductoCompB(int idProducto) {
        Producto prod = new ProductoCompBAdpter();
        return prod.obtenerPrecio(idProducto);
    }

    private String usarProductoCompC(int idProducto) {
        Producto prod = new ProductoCompCAdpter();
        return prod.obtenerPrecio(idProducto);
    }
}
