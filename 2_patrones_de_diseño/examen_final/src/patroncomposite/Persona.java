package patroncomposite;

public class Persona implements IPension {
    private String nombre;
    private String apellido;
    private int edad;
    private int pension;
    private String afp;

    public Persona(String nombre, String apellido, int edad, int pension, String afp) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setPension(pension);
        setAfp(afp);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int getPension() {
        return pension;
    }

    public void setPension(int pension) {
        this.pension = pension;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

}