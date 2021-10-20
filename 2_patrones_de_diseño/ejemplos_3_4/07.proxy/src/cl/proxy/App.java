package cl.proxy;

import cl.proxy.inter.ICuenta;
import cl.proxy.inter.impl.CuentaBancoBImpl;
import cl.proxy.model.Cuenta;
import cl.proxy.proxy.CuentaProxy;

public class App {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(1, "iplacex", 100);
        ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoBImpl());
        cuentaProxy.mostrarSaldo(c);
        c = cuentaProxy.depositarDinero(c, 50);
        c = cuentaProxy.retirarDinero(c, 20);
        cuentaProxy.mostrarSaldo(c);
    }
}
