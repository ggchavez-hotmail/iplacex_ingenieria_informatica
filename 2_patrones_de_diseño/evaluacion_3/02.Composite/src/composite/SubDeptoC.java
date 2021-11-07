package composite;

public class SubDeptoC extends SubDepartamento {

    public SubDeptoC(String codigoTicket) {
        this.setCodigoTicket(codigoTicket);
        this.setSubDepartamento(SubDepartamento.SubDeptoC);
    }

    @Override
    public void mostrar() {
        System.out.println("SubDeptoC: " + this.getCodigoTicket());
    }

}
