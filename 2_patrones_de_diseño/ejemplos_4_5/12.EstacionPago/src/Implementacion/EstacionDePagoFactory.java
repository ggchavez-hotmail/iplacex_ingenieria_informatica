package Implementacion;

public interface EstacionDePagoFactory {
    public TarifaStrategy creaTarifaStrategy();

    public Recibo crearRecibo(int tiempoEstacionado);

    public DisplayStrategy creaDisplayStrategy();
}
