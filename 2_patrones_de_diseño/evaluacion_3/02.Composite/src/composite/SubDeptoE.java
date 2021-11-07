package composite;

public class SubDeptoE extends SubDepartamento {

    public SubDeptoE(String codigoTicket) {
        this.setCodigoTicket(codigoTicket);
        this.setSubDepartamento(SubDepartamento.SubDeptoA);
    }

    @Override
    public void mostrar() {
        System.out.println("SubDeptoA: " + this.getCodigoTicket());
    }

}
