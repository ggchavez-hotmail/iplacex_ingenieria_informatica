package composite;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Categoria> categorias = new ArrayList<Categoria>();

        SubCategoria mas = new SubCategoria("Masculino");
        SubCategoria fem = new SubCategoria("Femenino");

        categorias.add(new Categoria("Calzado"));
        categorias.get(0).nuevaClasificacion(mas);
        categorias.get(0).nuevaClasificacion(fem);

        categorias.add(new Categoria("Poleras"));
        categorias.get(1).nuevaClasificacion(mas);
        categorias.get(1).nuevaClasificacion(fem);

        for (Categoria categoria : categorias) {
            categoria.mostrar();
        }
    }
}
