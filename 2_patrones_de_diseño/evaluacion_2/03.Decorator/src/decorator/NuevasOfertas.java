package decorator;

public class NuevasOfertas extends CompraDecorada {
    public NuevasOfertas(ICompraNormal compraDecorada) {
        super(compraDecorada);
    }

    @Override
    public void finalizarCompra(Compra c) {
        compraDecorada.finalizarCompra(c);
        mostrarOfertaYDescuentos(c);
    }

    public void mostrarOfertaYDescuentos(Compra c) {
        System.out.println("Posee oferta del 10% pagando con Banco Rojo");
        System.out.println("Producto relacionado con 5% de descuento");
    }

}
