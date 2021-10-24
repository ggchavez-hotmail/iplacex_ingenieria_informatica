package composite;

public class SubCategoria extends TipoClasificacion {

    public SubCategoria(String nombre) {
        this.setNombre(nombre);
        this.setTipoClasificacion(TipoClasificacion.SUBCATEGORIA);
    }

    @Override
    public void mostrar() {
        System.out.println("SubCategoria:" + this.getNombre());
    }

}
