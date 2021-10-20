package com.seguros.decorador;

import com.seguros.interf.ITarjetadeCredito;
import com.seguros.model.Compra;

public abstract class CompraDecorador implements ITarjetadeCredito {
    protected ITarjetadeCredito compraDecorada;

    public CompraDecorador(ITarjetadeCredito compraDecorada) {
        this.compraDecorada = compraDecorada;
    }

    @Override
    public void ingresarCompra(Compra c) {
        this.compraDecorada.ingresarCompra(c);
    }
}
