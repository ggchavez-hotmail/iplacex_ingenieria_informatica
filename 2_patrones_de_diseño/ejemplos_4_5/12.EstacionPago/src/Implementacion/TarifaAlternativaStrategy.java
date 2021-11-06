package Implementacion;

import java.util.*;

public class TarifaAlternativaStrategy implements TarifaStrategy {
    private TarifaStrategy finSemanaStrategy, diaSemanaStrategy, estadoActual;
    private DecisionFinSemanaStrategy decisionStrategy;

    public TarifaAlternativaStrategy(TarifaStrategy finSemanaStrategy, TarifaStrategy diaSemanaStrategy,
            DecisionFinSemanaStrategy decisionStrategy) {
        this.finSemanaStrategy = finSemanaStrategy;
        this.diaSemanaStrategy = diaSemanaStrategy;
        this.estadoActual = null;
        this.decisionStrategy = decisionStrategy;
    }

    public int CalculaTiempo(int monto) {
        if (decisionStrategy.isFinSemana()) {
            estadoActual = finSemanaStrategy;
        } else {
            estadoActual = diaSemanaStrategy;
        }
        return estadoActual.CalculaTiempo(monto);
    }
}
