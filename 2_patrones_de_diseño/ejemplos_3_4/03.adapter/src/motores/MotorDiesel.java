package motores;

public class MotorDiesel extends Motor  {
    public MotorDiesel() {
        super();
        System.out.println("Creando el motor a diesel");
    }

    @Override
    public void encender() {
        System.out.println("encendido motor a diesel");

    }

    @Override
    public void acelerar() {
        System.out.println("acelerando el motor a diesel");

    }

    @Override
    public void apagar() {
        System.out.println("Apagando motor a diesel");

    }
}
