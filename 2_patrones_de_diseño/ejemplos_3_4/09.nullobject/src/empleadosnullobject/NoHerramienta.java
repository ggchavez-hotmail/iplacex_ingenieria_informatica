package empleadosnullobject;

public class NoHerramienta extends Herramienta {
    @Override
    public String getNombre() {
        return "No Existe Herramienta";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
