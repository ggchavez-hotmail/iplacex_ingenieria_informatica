package Implementacion;

public class EstacionamientoCFactory implements EstacionDePagoFactory {

    public TarifaStrategy creaTarifaStrategy() {
        return new TarifaAlternativaStrategy(new TarifaLinealStrategy(), new TarifaProgresivaStrategy(),
                new DecisionRelojStrategy());
    }

    public Recibo crearRecibo(int tiempoEstacionado) {
        return new ReciboEstandar(tiempoEstacionado);
    }

    public DisplayStrategy creaDisplayStrategy() {
        return new ValorDisplayStrategy();
    }
}
