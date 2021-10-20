
public class CalculadoraFacade {
    public static void main(String[] args) {

        RestaNumeros rn = new RestaNumeros();
        System.out.println("Resultado de la Resta: " + rn.resta(30, 10));

        SumaNumeros sn = new SumaNumeros();
        System.out.println("Resultado de la Suma: " + sn.suma(30, 10));

        facadeEjemplo ej = new facadeEjemplo();
        ej.usarCalculadoraParaSumarORestar(10, 30, "+");
        ej.usarCalculadoraParaSumarORestar(10, 30, "-");
    }
}