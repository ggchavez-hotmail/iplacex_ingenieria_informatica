package Implementacion;

public interface EstacionDePago {
    public void agregaPago(int moneda) throws MonedaNoPermitidaException;

    public int leeDisplay();

    public Recibo compra();

    public void cancela();
}
