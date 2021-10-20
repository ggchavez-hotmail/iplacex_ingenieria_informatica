package banco;

import java.util.ArrayList;
import java.util.List;

//import banco.IOperacion;

public class Invoker {
    private List<IOperacion> operaciones = new ArrayList<>();

    public void recibirOperacion(IOperacion operacion) {
        this.operaciones.add(operacion);
    }

    public void realizarOperaciones() {
        this.operaciones.forEach(x -> x.execute());
        this.operaciones.clear();
    }
}
