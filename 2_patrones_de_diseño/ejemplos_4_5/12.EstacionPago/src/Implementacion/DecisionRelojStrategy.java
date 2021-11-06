package Implementacion;

import java.util.*;

public class DecisionRelojStrategy implements DecisionFinSemanaStrategy {
    public boolean isFinSemana() {
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        int diaDeSemana = c.get(Calendar.DAY_OF_WEEK);
        return (diaDeSemana == Calendar.SATURDAY || diaDeSemana == Calendar.SUNDAY);
    }

}
