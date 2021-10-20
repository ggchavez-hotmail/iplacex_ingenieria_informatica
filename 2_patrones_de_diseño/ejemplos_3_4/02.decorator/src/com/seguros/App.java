package com.seguros;

import com.seguros.decorador.SeguroDecorador;
import com.seguros.interf.ITarjetadeCredito;
import com.seguros.interf.impl.TarjetadeCredito;
import com.seguros.model.Compra;

public class App {
    public static void main(String[] args) {
        Compra c = new Compra(1, "Televisor", 350000);

        ITarjetadeCredito compra = new TarjetadeCredito();
        ITarjetadeCredito compraAsegurada = new SeguroDecorador(compra);

        compraAsegurada.ingresarCompra(c);
    }
}
