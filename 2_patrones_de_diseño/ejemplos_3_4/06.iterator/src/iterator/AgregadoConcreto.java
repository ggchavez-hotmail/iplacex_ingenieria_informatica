package iterator;

import java.util.Vector;

public class AgregadoConcreto implements Agregado {
    protected Vector aDatos = new Vector();

    public AgregadoConcreto() {
        this.llenar();
    }

    @Override
    public Iterador getIterador() {
        return new IteradorConcreto(this);
    }

    public void llenar() {
        this.aDatos.add(new String("JOSE"));
        this.aDatos.add(new String("MARTA"));
        this.aDatos.add(new String("ANTONIO"));
        this.aDatos.add(new String("ROMINA"));
    }
}
