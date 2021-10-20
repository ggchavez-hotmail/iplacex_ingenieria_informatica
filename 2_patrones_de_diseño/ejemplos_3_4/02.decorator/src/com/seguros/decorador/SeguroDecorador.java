package com.seguros.decorador;

import com.seguros.interf.ITarjetadeCredito;
import com.seguros.model.Compra;

public class SeguroDecorador extends CompraDecorador {
    public SeguroDecorador(ITarjetadeCredito compraDecorada) {
        super(compraDecorada);
    }

    @Override
    public void ingresarCompra(Compra c) {
        compraDecorada.ingresarCompra(c);
        agregarSeguro(c);
    }

    public void agregarSeguro(Compra c) {
        System.out.println("Se agrego un Seguro al Producto Adquirido" + c.getProducto());
    }
}
