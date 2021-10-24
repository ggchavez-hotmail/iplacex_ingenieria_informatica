package controlador;

import modelo.Logica;
import vista.VentanaBuscar;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Principal {
    Logica miLogica;
    VentanaPrincipal miVentanaPrincipal;
    VentanaBuscar miVentanaBuscar;
    VentanaRegistro miVentanaRegistro;
    Coordinador miCoordinador;

    public static void main(String[] args) {
        Principal miPrincipal = new Principal();
        miPrincipal.iniciar();
    }

    private void iniciar() {
        miVentanaPrincipal = new VentanaPrincipal();
        miVentanaRegistro = new VentanaRegistro();
        miVentanaBuscar = new VentanaBuscar();
        miLogica = new Logica();
        miCoordinador = new Coordinador();

        miVentanaPrincipal.setCoordinador(miCoordinador);
        miVentanaRegistro.setCoordinador(miCoordinador);
        miVentanaBuscar.setCoordinador(miCoordinador);
        miLogica.setCoordinador(miCoordinador);

        miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
        miCoordinador.setMiVentanaRegistro(miVentanaRegistro);
        miCoordinador.setMiVentanaBuscar(miVentanaBuscar);
        miCoordinador.setMiLogica(miLogica);

        miVentanaPrincipal.setVisible(true);

    }
}
