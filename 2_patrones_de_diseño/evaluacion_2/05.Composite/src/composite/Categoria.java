package composite;

import java.util.ArrayList;
import java.util.List;

public class Categoria extends TipoClasificacion {

    List<TipoClasificacion> clasificaciones = new ArrayList<TipoClasificacion>();

    public Categoria(String nombre) {
        this.setNombre(nombre);
        this.setTipoClasificacion(TipoClasificacion.CATEGORIA);
    }

    public void nuevaClasificacion(TipoClasificacion clasificacion) {
        clasificaciones.add(clasificacion);
    }

    public void borrarClasificacion(TipoClasificacion clasificacion) {
        clasificaciones.remove(clasificacion);
    }

    public List<TipoClasificacion> getClasificaciones() {
        return clasificaciones;
    }

    public TipoClasificacion getClasificacion(int pos) {
        return clasificaciones.get(pos);
    }

    @Override
    public void mostrar() {
        System.out.println("Categoria:" + this.getNombre());

        for (TipoClasificacion clasificacion : clasificaciones) {
            clasificacion.mostrar();
        }
    }
}
