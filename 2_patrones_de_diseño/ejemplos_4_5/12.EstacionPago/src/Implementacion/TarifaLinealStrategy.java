package Implementacion;

public class TarifaLinealStrategy implements TarifaStrategy {
    public int CalculaTiempo(int monto) {
        return monto * 2 / 5;
    }

}
