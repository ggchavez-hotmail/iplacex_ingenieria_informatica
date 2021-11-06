package Implementacion;

import java.util.*;

public class TiempoDisplayStrategy implements DisplayStrategy {

    public int calcularSalida(int minutos) {
        Calendar now = GregorianCalendar.getInstance();
        now.add(Calendar.MINUTE, minutos);
        int resultado = now.get(Calendar.HOUR_OF_DAY) * 100 + now.get(Calendar.MINUTE);
        return resultado;
    }

}
