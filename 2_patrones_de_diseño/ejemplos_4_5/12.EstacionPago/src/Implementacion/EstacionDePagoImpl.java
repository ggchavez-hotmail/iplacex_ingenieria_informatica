package Implementacion;

public class EstacionDePagoImpl implements EstacionDePago {
    private int insertadas;
    private int tiempoComprado;
    private TarifaStrategy tarifaStrategy;
    private DisplayStrategy displayStrategy;
    private EstacionDePagoFactory factory;

    public EstacionDePagoImpl(EstacionDePagoFactory factory) {
        this.factory = factory;
        this.tarifaStrategy = factory.creaTarifaStrategy();
        this.displayStrategy = factory.creaDisplayStrategy();
        reset();
    }

    public void agregaPago(int moneda) throws MonedaNoPermitidaException {
        switch (moneda) {
        case 5:
            break;
        case 10:
            break;
        case 25:
            break;
        default:
            throw new MonedaNoPermitidaException("Moneda Invalida: " + moneda);
        }
        insertadas += moneda;
        tiempoComprado = tarifaStrategy.CalculaTiempo(insertadas);
    }

    public int leeDisplay() {
        return displayStrategy.calcularSalida(tiempoComprado);
    }

    public Recibo compra() {
        Recibo r = factory.crearRecibo(tiempoComprado);
        reset();
        return r;
    }

    public void cancela() {
        reset();
    }

    private void reset() {
        insertadas = 0;
        tiempoComprado = 0;
    }

}
