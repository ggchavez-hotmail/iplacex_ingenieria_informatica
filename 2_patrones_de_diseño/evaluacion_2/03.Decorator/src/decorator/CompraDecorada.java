package decorator;

public abstract class CompraDecorada implements ICompraNormal {
    protected ICompraNormal compraDecorada;

    public CompraDecorada(ICompraNormal compraDecorada) {
        this.compraDecorada = compraDecorada;
    }

    @Override
    public void finalizarCompra(Compra c) {
        this.compraDecorada.finalizarCompra(c);
    }

}
