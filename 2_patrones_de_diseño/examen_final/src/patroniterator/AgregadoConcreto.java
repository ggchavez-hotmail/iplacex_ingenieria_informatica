package patroniterator;

import java.util.List;
import java.util.Vector;

import modelo.Sipen;
import patronfacade.InvocarAPI;

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

        InvocarAPI invocarAPI = new InvocarAPI();
        List<Sipen> jsonAnswer = invocarAPI.invocarAPISipen("http://localhost:3000/", "Sipen");

        int indice = 0;
        for (Sipen item : jsonAnswer) {
            indice++;
            this.aDatos.add(new String("Registro " + indice + " -> Nombre: " + item.getNombre() + ", Apellido: "
                    + item.getApellido() + ", Edad: " + item.getEdad() + ", Pension: " + item.getPension() + ", AFP: "
                    + item.getAfp()));
        }

    }
}
