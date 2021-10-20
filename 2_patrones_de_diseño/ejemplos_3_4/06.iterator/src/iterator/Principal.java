package iterator;

public class Principal {
    public static void main(String[] args) {
        try {
            AgregadoConcreto agregado = new AgregadoConcreto();
            Iterador iterador = agregado.getIterador();
            String obj = (String) iterador.primero();
            System.out.println(obj);
            iterador.siguiente();
            iterador.siguiente();
            System.out.println((String) iterador.actual() + "\n");
            iterador.primero();
            while (iterador.hayMas() == true) {
                System.out.println(iterador.siguiente());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
