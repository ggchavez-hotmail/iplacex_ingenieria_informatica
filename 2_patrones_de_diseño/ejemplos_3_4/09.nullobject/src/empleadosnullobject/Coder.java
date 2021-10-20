package empleadosnullobject;

public class Coder extends Herramienta {
    public Coder(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
