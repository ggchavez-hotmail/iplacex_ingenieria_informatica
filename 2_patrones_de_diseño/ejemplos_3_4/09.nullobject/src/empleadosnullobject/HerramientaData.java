package empleadosnullobject;

//import empleadosnullobject.NoHerramienta;

public class HerramientaData {
    public static final String[] nombres = { "Martillo", "Alicate", "Huincha" };

    public static Herramienta getHerramienta(String nombre) {
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                return new Coder(nombre);
            }
        }
        return new NoHerramienta();
    }
}
