package decorator;

public class CompraNormal implements ICompraNormal {

    @Override
    public void finalizarCompra(Compra c) {
        System.out.println("---------------------------");
        System.out.println("Compra: " + c.getProducto());
    }
}
