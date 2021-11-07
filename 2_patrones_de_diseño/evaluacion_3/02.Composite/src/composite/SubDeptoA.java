package composite;

public class SubDeptoA extends SubDepartamento {

    public SubDeptoA(String codigoTicket) {
        this.setCodigoTicket(codigoTicket);
        this.setSubDepartamento(SubDepartamento.SubDeptoA);
    }

    @Override
    public void mostrar() {
        System.out.println("SubDeptoA: " + this.getCodigoTicket());
    }

}
