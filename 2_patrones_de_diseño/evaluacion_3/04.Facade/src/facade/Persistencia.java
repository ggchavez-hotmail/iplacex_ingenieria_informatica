package facade;

public class Persistencia {

    public int totalDiario(int idSubDepartamento) {

        return idSubDepartamento * 10;
    }

    public int totalSemanal(int idSubDepartamento) {

        return idSubDepartamento * 10 * 5;
    }

    public int totalMensual(int idSubDepartamento) {

        return idSubDepartamento * 10 * 20;
    }
}
