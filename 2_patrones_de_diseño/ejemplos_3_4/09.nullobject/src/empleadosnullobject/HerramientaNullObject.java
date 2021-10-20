package empleadosnullobject;

public class HerramientaNullObject {
    public static void main(String[] args) {
        Herramienta herr1 = HerramientaData.getHerramienta("Martillo");
        Herramienta herr2 = HerramientaData.getHerramienta("Taladro");
        Herramienta herr3 = HerramientaData.getHerramienta("Alicate");
        Herramienta herr4 = HerramientaData.getHerramienta("Sierra");
        Herramienta herr5 = HerramientaData.getHerramienta("Huincha");

        System.out.println(herr1.getNombre());
        System.out.println(herr2.getNombre());
        System.out.println(herr3.getNombre());
        System.out.println(herr4.getNombre());
        System.out.println(herr5.getNombre());
    }
}
