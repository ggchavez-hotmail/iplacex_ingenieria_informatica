package composite;

public class SubDeptoD extends SubDepartamento {

    public SubDeptoD(String codigoTicket) {
        this.setCodigoTicket(codigoTicket);
        this.setSubDepartamento(SubDepartamento.SubDeptoD);
    }

    @Override
    public void mostrar() {
        System.out.println("SubDeptoD: " + this.getCodigoTicket());
    }

}
