package Implementacion;

public class EstacionamientoAFactory implements EstacionDePagoFactory {

    public TarifaStrategy creaTarifaStrategy() {
        return new TarifaLinealStrategy();
    }

    public Recibo crearRecibo(int tiempoEstacionado) {
        return new ReciboEstandar(tiempoEstacionado);
    }

    public DisplayStrategy creaDisplayStrategy() {
        return new TiempoDisplayStrategy();
    }

}
