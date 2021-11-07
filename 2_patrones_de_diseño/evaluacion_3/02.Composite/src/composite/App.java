package composite;

public class App {
    public static void main(String[] args) {

        SubDeptoA ticket1 = new SubDeptoA("A1");
        SubDeptoA ticket2 = new SubDeptoA("A2");
        SubDeptoB ticket3 = new SubDeptoB("A3");
        SubDeptoC ticket4 = new SubDeptoC("A4");
        SubDeptoD ticket5 = new SubDeptoD("A5");
        SubDeptoE ticket6 = new SubDeptoE("A6");

        ticket1.mostrar();
        ticket2.mostrar();
        ticket3.mostrar();
        ticket4.mostrar();
        ticket5.mostrar();
        ticket6.mostrar();
    }
}
