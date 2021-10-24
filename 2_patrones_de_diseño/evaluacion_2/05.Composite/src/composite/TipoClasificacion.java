package composite;

public abstract class TipoClasificacion {
    public static final int CATEGORIA = 1;
    public static final int SUBCATEGORIA = 2;

    protected String nombre = "";
    protected int tipoClasificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(int tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    public abstract void mostrar();
}
