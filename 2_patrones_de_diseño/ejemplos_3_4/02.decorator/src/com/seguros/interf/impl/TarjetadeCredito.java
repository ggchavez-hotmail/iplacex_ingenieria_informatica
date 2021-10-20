package com.seguros.interf.impl;

import com.seguros.interf.ITarjetadeCredito;
import com.seguros.model.Compra;

public class TarjetadeCredito implements ITarjetadeCredito {
    @Override
    public void ingresarCompra(Compra c) {
        System.out.println("---------------------------");
        System.out.println("Se ingreso Una nueva Compra");
        System.out.println("Compra: " + c.getProducto());
    }
}
