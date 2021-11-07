package composite;

public class SubDeptoB extends SubDepartamento {

    public SubDeptoB(String codigoTicket) {
        this.setCodigoTicket(codigoTicket);
        this.setSubDepartamento(SubDepartamento.SubDeptoB);
    }

    @Override
    public void mostrar() {
        System.out.println("SubDeptoB: " + this.getCodigoTicket());
    }

}
