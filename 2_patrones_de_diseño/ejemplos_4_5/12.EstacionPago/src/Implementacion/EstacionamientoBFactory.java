package Implementacion;

public class EstacionamientoBFactory implements EstacionDePagoFactory {

    public TarifaStrategy creaTarifaStrategy() {
        return new TarifaLinealStrategy();
    }

    public Recibo crearRecibo(int tiempoEstacionado) {
        return new ReciboEstandar(tiempoEstacionado, true);
    }

    public DisplayStrategy creaDisplayStrategy() {
        return new ValorDisplayStrategy();
    }
}
