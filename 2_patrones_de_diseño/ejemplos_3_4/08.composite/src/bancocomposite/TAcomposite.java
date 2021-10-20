package bancocomposite;

public class TAcomposite {
    public static void main(String[] args) {
        Banco banco = new Banco();

        SectorAdministrativo administracion = new SectorAdministrativo();
        SectorCajas cajas = new SectorCajas();
        SectorContaduria contaduria = new SectorContaduria();
        SectorGerencia gerencia = new SectorGerencia();
        SectorRRHH rrhh = new SectorRRHH();

        banco.agregar(administracion);
        banco.agregar(contaduria);
        banco.agregar(gerencia);
        administracion.agregar(cajas);
        administracion.agregar(rrhh);

        Empleado cajero1 = new Empleado("Nafer Salas", "Cajero", 300);
        Empleado cajero2 = new Empleado("Diana Roa", "Cajero", 300);

        cajas.agregar(cajero1);
        cajas.agregar(cajero2);

        Empleado gerente = new Empleado("Alvaro Molina", "Gerente", 500);
        gerencia.agregar(gerente);

        Empleado selector = new Empleado("Pedro Cañas", "RRHH", 350);
        rrhh.agregar(selector);

        Empleado contador = new Empleado("Monica Ardilla", "Contador", 380);
        contaduria.agregar(contador);

        System.out.println("Total de sueldos Banco: " + banco.getSueldo());
    }
}
