package patroncomposite;

import java.util.ArrayList;

public class CompositePension implements IPension {
    private ArrayList<IPension> persona = new ArrayList<IPension>();

    @Override
    public int getPension() {
        int sumador = 0;
        for (int i = 0; i < persona.size(); i++) {
            sumador = sumador + persona.get(i).getPension();
        }
        return sumador;
    }

    public void agregar(IPension p) {
        persona.add(p);
    }

}
