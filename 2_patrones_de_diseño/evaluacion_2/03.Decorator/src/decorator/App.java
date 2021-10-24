package decorator;

public class App {
    public static void main(String[] args) {
        Compra c = new Compra(2, "Zapatos", 100000);

        ICompraNormal compra = new CompraNormal();
        ICompraNormal compraNuevasOfertas = new NuevasOfertas(compra);
        
        compraNuevasOfertas.finalizarCompra(c);

    }
}
