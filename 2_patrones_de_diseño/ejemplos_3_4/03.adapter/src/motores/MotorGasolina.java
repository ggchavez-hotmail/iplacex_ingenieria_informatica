package motores;

public class MotorGasolina extends Motor {
    public MotorGasolina() {
        super();
        System.out.println("Creando el motor a gasolina");
    }

    @Override
    public void encender() {
        System.out.println("encendido motor a gasolina");

    }

    @Override
    public void acelerar() {
        System.out.println("acelerando el motor a gasolina");

    }

    @Override
    public void apagar() {
        System.out.println("Apagando motor a gasolina");

    }
}
