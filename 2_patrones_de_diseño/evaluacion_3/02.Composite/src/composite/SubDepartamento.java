package composite;

public abstract class SubDepartamento {
    public static final int SubDeptoA = 1;
    public static final int SubDeptoB = 2;
    public static final int SubDeptoC = 3;
    public static final int SubDeptoD = 4;
    public static final int SubDeptoE = 5;

    protected String codigoTicket = "";
    protected int subDepartamento;

    public String getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(String codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public int getSubDepartamento() {
        return subDepartamento;
    }

    public void setSubDepartamento(int subDepartamento) {
        this.subDepartamento = subDepartamento;
    }

    public abstract void mostrar();
}
