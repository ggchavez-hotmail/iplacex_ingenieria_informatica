
public class facadeEjemplo {
    public void usarCalculadoraParaSumarORestar(int a, int b, String operacion) {
        System.out.println("Se usa calculadora para: " + operacion);
        Calculadora calc = new Calculadora(a, b, operacion);
        System.out.println("Resultado de la operacion: " + calc.operacion());
    }
}